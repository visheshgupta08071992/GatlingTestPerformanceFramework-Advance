## Understanding GatlingTestPerformanceFramework

**Framework Structure**

![image](https://user-images.githubusercontent.com/52998083/209800792-32e3ed87-187d-4ba2-998b-1d6f82568df7.png)

### Under Resource

**bodies** - This package holds the request payloads. For example, you can have requests templates for various requests.

**data** - This package holds the data you need to feed to your tests, such as CSVs.

### Under Scala

**config** - In the config package, create a Scala object called Config. This will hold various configurations for our project such as application URLs, default users, etc…

**Request** - The requests package holds different operation requests.

**Scenario** - The scenario package holds the business scenarios.

**Simulation** - Finally, we have the Simulations in the simulations package. You can think of simulations as different load profiles.


### Referances
Framework Referance - https://devqa.io/gatling-maven-performance-test-framework/ </br>

Github Repo - <br>  
https://github.com/visheshgupta08071992/Gatling/edit/master/Understanding%20Gatling.md  </br>

https://github.com/visheshgupta08071992/GatlingPerformanceTestingPractise </br>
