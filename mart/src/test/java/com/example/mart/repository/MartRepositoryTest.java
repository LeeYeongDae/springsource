package com.example.mart.repository;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.mart.entity.mart.Category;
import com.example.mart.entity.mart.CategoryItem;
import com.example.mart.entity.mart.Delivery;
import com.example.mart.entity.mart.Member;
import com.example.mart.entity.mart.Order;
import com.example.mart.entity.mart.OrderedProduct;
import com.example.mart.entity.mart.Product;
import com.example.mart.entity.mart.constant.DeliveryStatus;
import com.example.mart.entity.mart.constant.OrderStatus;

@SpringBootTest
public class MartRepositoryTest {

     @Autowired
     private MemberRepository memberRepository;
     @Autowired
     private OrderRepository orderRepository;
     @Autowired
     private OrderedProductRepository orderedProductRepository;
     @Autowired
     private ProductRepository productRepository;
     @Autowired
     private DeliveryRepository deliveryRepository;
     @Autowired
     private CategoryRepository categoryRepository;
     @Autowired
     private CategoryItemRepository categoryItemRepository;

     @Test
     public void testMemberInsert() {
          IntStream.rangeClosed(1, 5).forEach(i -> {
               Member member = Member.builder()
                         .name("user" + i)
                         .post("1650" + i)
                         .address("한국" + i)
                         .specificAddress("853-" + i)
                         .build();
               memberRepository.save(member);
          });
     }

     @Test
     public void testProductInsert() {
          IntStream.rangeClosed(1, 5).forEach(i -> {
               Product product = Product.builder()
                         .name("item" + i)
                         .price(10000 * i)
                         .stock(3 * i)
                         .build();
               productRepository.save(product);
          });
     }

     @Test
     public void testOrderInsert() {
          Order order = Order.builder()
                    .member(Member.builder().id(11L).build())
                    .orderDate(LocalDateTime.now())
                    .status(OrderStatus.ORDER)
                    .build();

          orderRepository.save(order);

          OrderedProduct orderedProduct = OrderedProduct.builder()
                    .product(productRepository.findById(2L).get())
                    .order(order)
                    .orderPrice(60000)
                    .count(1)
                    .build();
          orderedProductRepository.save(orderedProduct);
     }

     @Test
     public void readOrderTest1() {
          // Order order = orderRepository.findById(2L).get();
     }

     @Test
     public void testOrderInsert2() {
          Order order = Order.builder()
                    .member(Member.builder().id(11L).build())
                    .orderDate(LocalDateTime.now())
                    .status(OrderStatus.ORDER)
                    .build();

          OrderedProduct orderedProduct = OrderedProduct.builder()
                    .product(productRepository.findById(2L).get())
                    .order(order)
                    .orderPrice(60000)
                    .count(1)
                    .build();
          order.getLists().add(orderedProduct);

          orderRepository.save(order);

     }

     @Test
     public void testDeliveryInsert() {

          Delivery delivery = Delivery.builder()
                    .post("1650")
                    .address("한국")
                    .specificAddress("853-1")
                    .status(DeliveryStatus.READY)
                    .build();
          deliveryRepository.save(delivery);

          Order order = orderRepository.findById(2L).get();
          order.setDelivery(delivery);
          orderRepository.save(order);
     }

     @Test
     public void testDeliveryRead() {
          System.out.println(deliveryRepository.findById(1L));

          Order order = orderRepository.findById(4L).get();
          System.out.println(order.getDelivery().getStatus());
     }

     @Transactional
     @Test
     public void testDeliveryRead2() {
          Delivery delivery = deliveryRepository.findById(1L).get();
          System.out.println("주문 조회 : " + delivery.getOrder());
          System.out.println("주문자 조회 : " + delivery.getOrder().getMember());
          System.out.println("주문품 조회 : " + delivery.getOrder().getLists());
     }

     @Test
     public void testDeliveryInsert2() {

          Delivery delivery = Delivery.builder()
                    .post("1650")
                    .address("한국")
                    .specificAddress("853-1")
                    .status(DeliveryStatus.READY)
                    .build();

          Order order = orderRepository.findById(2L).get();
          order.setDelivery(delivery);
          orderRepository.save(order);
     }

     @Test
     public void orderDeleteTest() {
          orderRepository.deleteById(3L);
     }

     @Test
     public void categoryInsertTest1() {
          Category category1 = Category.builder().name("가전").build();
          Category category2 = Category.builder().name("식품").build();
          Category category3 = Category.builder().name("생활").build();

          categoryRepository.save(category1);
          categoryRepository.save(category2);
          categoryRepository.save(category3);

          Product item1 = Product.builder().name("TV").price(200000).stock(10).build();
          productRepository.save(item1);

          CategoryItem categoryItem = CategoryItem.builder().category(category1).item(item1).build();
          categoryItemRepository.save(categoryItem);

          item1 = Product.builder().name("달래").price(3000).stock(16).build();
          productRepository.save(item1);

          categoryItem = CategoryItem.builder().category(category2).item(item1).build();
          categoryItemRepository.save(categoryItem);

          item1 = Product.builder().name("샴푸").price(5000).stock(6).build();
          productRepository.save(item1);

          categoryItem = CategoryItem.builder().category(category3).item(item1).build();
          categoryItemRepository.save(categoryItem);

     }

     @Transactional
     @Test
     public void readCategoryTest() {
          CategoryItem categoryItem = categoryItemRepository.findById(1L).get();

          System.out.println(categoryItem);
          System.out.println(categoryItem.getCategory().getName());
          System.out.println(categoryItem.getItem().getName());
     }
}
