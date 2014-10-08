package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-05T08:27:18")
@StaticMetamodel(Detection.class)
public class Detection_ { 

    public static volatile SingularAttribute<Detection, Date> date;
    public static volatile SingularAttribute<Detection, String> deviceIp;
    public static volatile SingularAttribute<Detection, String> location;
    public static volatile SingularAttribute<Detection, String> numberplate;
    public static volatile SingularAttribute<Detection, Integer> featureId;
    public static volatile SingularAttribute<Detection, Integer> detectionId;

}