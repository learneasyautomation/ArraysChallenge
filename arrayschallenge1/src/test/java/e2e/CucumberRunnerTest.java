package e2e;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "/arrayschallenge1/src/test/java/e2e/ArraysChallenge.feature" }, glue = "/arrayschallenge1/src/test/java/e2e/TestArraysChallenge")
 
public class CucumberRunnerTest {
 
}