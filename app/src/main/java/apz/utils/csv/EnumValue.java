package apz.utils.csv;
import java.lang.annotation.*;

@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValue
{
    public String name();

    public String value();
}