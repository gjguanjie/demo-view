package com.cloud;

import com.cloud.entity.Person;
import com.cloud.entity.User;
import com.cloud.entity.UserCoupon;
import com.cloud.repository.PersonRepository;
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
    public void update() {
        UserCoupon coupon = new UserCoupon();
        Sort sort = Sort.by(Sort.Direction.DESC,"create_time");
        Pageable pageable = PageRequest.of(0,10);
        LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("t_user")         //从集合对象
                .localField("user_id")      //主表关联字段
                .foreignField("_id")        //从表关联字段
                .as("userList");
        Criteria criteriaMain = new Criteria();
        if (!StringUtils.isEmpty(coupon)) {
            Criteria c1 = Criteria.where("coupon_id").is(coupon.getCouponId());
            Criteria c2 = Criteria.where("shop_id").is(coupon.getCouponId());
            criteriaMain.andOperator(c1,c2);
        }
        AggregationOperation main = Aggregation.match(criteriaMain);
        Aggregation aggregationCount = Aggregation.newAggregation(main,lookupOperation); //查总数，不分页
        Aggregation aggregationPage = Aggregation.newAggregation(main,lookupOperation,Aggregation.skip(0),Aggregation.limit(10)); //分页
        int count = mongoTemplate.aggregate(aggregationCount,"t_user_coupon", UserCoupon.class).getMappedResults().size();
        List<UserCoupon> list = mongoTemplate.aggregate(aggregationPage,"t_user_coupon",UserCoupon.class).getMappedResults();
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
    }

}
