package org.example;

import redis.clients.jedis.Jedis;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Jedis jedisClient = null;
        try
        {
            jedisClient = new Jedis("localhost");
            System.out.println("Connection established successfully");
            jedisClient.hset("voucher1", "id", "11JI");
            jedisClient.hset("voucher1", "company", "facenet");
            jedisClient.hset("voucher2", "id", "12JI");
            jedisClient.hset("voucher2", "company", "facenet");
            jedisClient.hset("voucher3", "id", "13JI");
            jedisClient.hset("voucher3", "company", "facenet");
            jedisClient.zadd("voucherList", 3000, "voucher1");
            jedisClient.zadd("voucherList", 6000, "voucher2");
            jedisClient.zadd("voucherList", -1200, "voucher3");
            System.out.println("The data entered into the database" + jedisClient.ping());
        }
        catch (Exception e){
            System.out.println(e);
        }

        System.out.print("Enter your voucher ID: ");
        String voucherID = scan.nextLine();
        if(jedisClient.zscore("voucherList", voucherID)  == null){
            System.out.println("Voucher is not exist");
        } else if (jedisClient.zscore("voucherList", voucherID) > 0) {
            System.out.println("Your voucher details: ");
            System.out.println(jedisClient.hgetAll(voucherID) + "\nExpire: " + jedisClient.zscore("voucherList", voucherID));
            System.out.print("Do you want to use this voucher (Enter 'y' for 'yes' or 'n' for 'no'): ");
            String check = scan.nextLine();
            if(check.equalsIgnoreCase("y")){
                jedisClient.del(voucherID);
            } else {
                System.out.println("Thank you!");
            }
        } else {
            System.out.println("Your voucher was expired");
            jedisClient.del(voucherID);
        }
        //System.out.println(jedisClient.zrangeByScore ("voucherList",0, 99999999));
        System.out.println("Thanks");
    }
}