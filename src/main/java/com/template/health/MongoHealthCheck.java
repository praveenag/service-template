//package com.template.health;
//
//
//import com.codahale.metrics.health.HealthCheck;
//
//public class MongoHealthCheck extends HealthCheck {
//
//    private final Data mongoFactory;
//
//    public MongoHealthCheck(final MongoFactory mongoFactory) {
//        super("mongodb");
//        this.mongoFactory = mongoFactory;
//    }
//
//    @Override
//    protected final Result check() {
//        try {
//            mongoFactory.getMongo().getDatabaseNames();
//        } catch (Exception ex) {
//            return Result.unhealthy(ex.getCause().getMessage());
//        }
//
//        return Result.healthy();
//    }
//
//}
