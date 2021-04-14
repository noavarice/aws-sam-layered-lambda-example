package org.example.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.example.math.MathOps;

/**
 * AWS Lambda function example.
 *
 * @author noavarice
 * @since 0.0
 */
public class LambdaFunction implements RequestHandler<Byte, Integer> {

    @Override
    public Integer handleRequest(final Byte input, final Context context) {
        try {
            Files.walk(Paths.get("/opt"))
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input == null ? null : MathOps.quad(input);
    }
}
