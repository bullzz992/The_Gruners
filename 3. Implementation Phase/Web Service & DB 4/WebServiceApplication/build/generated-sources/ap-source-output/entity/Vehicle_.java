package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-04T00:56:16")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, String> stolen;
    public static volatile SingularAttribute<Vehicle, String> fines;
    public static volatile SingularAttribute<Vehicle, Integer> vehicleId;
    public static volatile SingularAttribute<Vehicle, Integer> ownerId;
    public static volatile SingularAttribute<Vehicle, String> numberPlate;
    public static volatile SingularAttribute<Vehicle, Integer> featureId;
    public static volatile SingularAttribute<Vehicle, String> roadworthy;

}