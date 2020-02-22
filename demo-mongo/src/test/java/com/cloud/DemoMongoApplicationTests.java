package com.cloud;

import com.cloud.entity.*;
import com.cloud.repository.AddressRepository;
import com.cloud.repository.PersonRepository;
import com.cloud.repository.StudentRepository;
import com.mongodb.BasicDBObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * https://bbs.csdn.net/topics/392557755?list=62460046
 * https://docs.spring.io/spring-data/mongodb/docs/2.2.3.RELEASE/reference/html/#mongo.transactions
 * https://www.cnblogs.com/huangxincheng/p/5728791.html
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMongoApplicationTests {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private AddressRepository addressRepository;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void save() {
        Person person = new Person();
        person.setId(1L);
        person.setAge(1);
        person.setCellNum("123456789011");
        person.setLastName("123");
        person.setWord("11");
        Person person1 = new Person();
        person1.setId(2L);
        person1.setAge(1);
        person1.setCellNum("123456789011");
        person1.setLastName("123");
        person1.setWord("11");
        personRepository.save(person);
        personRepository.save(person1);
    }

    @Test
    public void saveAddress() {
        Address address = new Address();
        address.setCity("连云港");
        address.setProvince("江苏");
        address.setNum("0002");
        /*Person person = new Person();
        person.setId(1L);
        person.setAge(1);
        person.setCellNum("123456789011");
        person.setLastName("123");
        person.setWord("11");
        List<Person> people = new ArrayList<>();
        people.add(person);
        address.setPersonList(people);*/
        address.setPersonId(1L);
        addressRepository.save(address);
    }

    @Test
    public void saveStudent() {
        Student student = new Student();
        student.setPersonId(4L);
        student.setSchool("光明小学");
        student.setAddressNum("0002");
        studentRepository.save(student);
    }

    @Test
    public void find() {
        Person person = new Person();
        person.setCellNum("123456789011");
        person.setLastName("123");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("cell_num", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("last_name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Person> example = Example.of(person,matcher);
        Pageable pageable = PageRequest.of(0,10);
        Page<Person> page = personRepository.findAll(example,pageable);
        System.out.println(page.getNumber());
    }

    @Test
    public void saveCoupon() {
        User user = new User();
        user.setName("张三");
        user.setOpenId("972700001");
        user.setShopId("880001");
        mongoTemplate.save(user);
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is("972700001"));
        query.addCriteria(Criteria.where("shopId").is("880001"));
        List<User> queryUser = mongoTemplate.find(query,User.class);
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.setCouponId("9900001");
        userCoupon.setCreateTime(LocalDateTime.now());
        userCoupon.setDrawTime(LocalDateTime.now());
        userCoupon.setDrawSource("LOCAL");
        userCoupon.setShopId("770001");
        userCoupon.setUserId(queryUser.get(0).getId());
        mongoTemplate.save(userCoupon);
        System.out.println();
    }

    /**
     * 一个主表，与多个子表关联查询
     * db.person.aggregate([
     *     {
     *         $lookup:
     *         {
     *             from: "student",
     *             localField: "_id",
     *             foreignField: "person_id",
     *             as: "studentList"
     *         }
     *
     *     }
     * ])
     */
    @Test
    public void treeAggregation() {
        LookupOperation studentOperation= LookupOperation.newLookup().
                from("student").             //从表名
                localField("_id").           //主集合关联字段
                foreignField("person_id").   //从集合关联字段
                as("studentList");           //查询结果名

        LookupOperation addressOperation = LookupOperation.newLookup().
                from("address").             //从表名
                localField("_id").           //主集合关联字段
                foreignField("person_id").   //从集合关联字段
                as("addressList");           //查询结果名
        Criteria criteria = Criteria.where("cell_num").regex("123456789011").and("age").is(1);//只查询名字中带有文的
        AggregationOperation match= Aggregation.match(criteria);
        Aggregation query = Aggregation.newAggregation(match,studentOperation,addressOperation);
        //Aggregation query = Aggregation.newAggregation(match,studentOperation);
        List<Person> results = mongoTemplate.aggregate(query,"person", Person.class).getMappedResults();
        System.out.println();
    }

    /**
     *
     * db.t_user_coupon.aggregate([
     *     {
     *         $lookup: {
     *                from: "t_user",
     *                localField: "user_id",
     *                foreignField: "_id",
     *                as: "userList"
     *              }
     *     },{
     *         $match: {
     *             "coupon_id":"9900001",
     *             "shop_id":"770001"
     *         }
     *     }
     * ])
     */
    @Test
    public void queryUserCoupon() {
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("t_user")         //从集合对象
                .localField("user_id")   //主集合关联字段
                .foreignField("_id")     // 从集合关联字段
                .as("userList");
        Criteria criteriaMain = Criteria.where("coupon_id").is("9900001").and("shop_id").is("770001");
        AggregationOperation main = Aggregation.match(criteriaMain);
        Aggregation aggregationCount = Aggregation.newAggregation(main,lookupOperation);
        List<UserCoupon> list = mongoTemplate.aggregate(aggregationCount,"t_user_coupon",UserCoupon.class).getMappedResults();
        System.out.println();
    }


}
