package apz.utils.csv;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumMapping
{
    public EnumValue[] value();
}