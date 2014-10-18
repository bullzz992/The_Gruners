package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-10-05T08:27:18")
@StaticMetamodel(Auditlog.class)
public class Auditlog_ { 

    public static volatile SingularAttribute<Auditlog, Date> date;
    public static volatile SingularAttribute<Auditlog, String> tableAccessed;
    public static volatile SingularAttribute<Auditlog, String> newRow;
    public static volatile SingularAttribute<Auditlog, String> action;
    public static volatile SingularAttribute<Auditlog, String> oldRow;
    public static volatile SingularAttribute<Auditlog, Integer> logId;

}