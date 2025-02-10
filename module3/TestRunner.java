/*
 * Test Runner
 * 
 * App which targets a number of different simulators to
 * run RTL tests. This assumes we have an API to each simulator
 * we can call
 * 
 */

package module3.discussion;
import java.util.ArrayList; 
import java.util.List;
import java.util.Map;
import java.util.Scanner; 
import java.util.HashMap;
import java.util.Random; 
import java.simulators.vcs;
import java.simulators.questa; 
import java.simulators.xcelium; 
import java.simulators.verilator; 

public class TestRunner { 
   public static void main(String[] args){
      int seed = 0; 
      // Ask user to identify the simulator to use
      System.out.println("Please enter your desired simulator: ");
      Scanner scanner = new Scanner(System.in);
      String simulator = scanner.nextLine();      
      // Check to make sure its a valid string 
      if(!simulator.equals("vcs") && !simulator.equals("questa") && !simulator.equals("xcelium") && !simulator.equals("verilator")){
         System.out.println("Invalid simulator. Please enter vcs, questa, xcelium, or verilator");
         return;
      }
      // Get names of tests to run and how many time to run each 
      Map<String, Integer> tests = new HashMap<String, Integer>();
      System.out.println("Please enter the name of the test, followed by a space and the number of times to run it: ");
      String test = scanner.nextLine();
      while(!test.equals("")){ // end when they dn't provide anything
         String[] testInfo = test.split(" ");
         tests.put(testInfo[0], Integer.parseInt(testInfo[1]));
         test = scanner.nextLine();
      }
      Random rand = new Random();
      
      // Assumes a runTest method exists in each simulator class
      // with the input testname and the seed to use for randomization

      // Run the tests with random seeds for each test
      if(simulator.equals("vcs")){
         vcs vcsSim = new vcs();
         for(String testname : tests.keySet()){
            for(int i = 0; i < tests.get(testname); i++){
               // generate random seed
               seed = rand.nextInt();
               vcsSim.runTest(testname, seed);
            }
         }
      } else if(simulator.equals("questa")){
         questa questaSim = new questa();
         for(String testname : tests.keySet()){
            for(int i = 0; i < tests.get(testname); i++){
               seed = rand.nextInt();
               questaSim.runTest(testname, seed);
            }
         }
      } else if(simulator.equals("xcelium")){
         xcelium xceliumSim = new xcelium();
         for(String testname : tests.keySet()){
            for(int i = 0; i < tests.get(testname); i++){
               seed = rand.nextInt();
               xceliumSim.runTest(testname, seed);
            }
         }
      } else {
         verilator verilatorSim = new verilator();
         for(String testname : tests.keySet()){
            for(int i = 0; i < tests.get(testname); i++){
               verilatorSim.runTest(testname, i);
            }
         }
      }
      
   } // end main()
} // end TestRunner
