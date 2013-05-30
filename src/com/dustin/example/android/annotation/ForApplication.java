package com.dustin.example.android.annotation;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IntelliJ IDEA.
 * User: dusting
 * Date: 5/28/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Qualifier @Retention(RUNTIME)
public @interface ForApplication {
}
