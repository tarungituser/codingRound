package utilities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CSVAnnotation {

    /**
     * <p>
     * This is a Custom Annotation.
     * </p>
     * It provides the facility to provide a CSV File Path to the GenericDataProvider class. In order
     * to use it, we need to add the following annotation to the test case declaration :-
     * \@CSVFileParameters(path = "test-data\\languagelist.csv", delimiter =
     * "###")
     */
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CSVFileParameters {
        String path();

        String delimiter();
    }
}
