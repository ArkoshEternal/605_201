# Mini Project One

## Design

For the tortoise and the hare simulation, we're asked to run a cycle by cycle simulation with individual character modes dictated by the program specification. Most basically, we have to have some representation of the position of the tortoise and the hare, and their position along a one dimensional number line - which starts at 1 and terminates after 100.

The simplest way to do this is to have two vars, which we treat as key - pair values of the animal and the position along the number line. On each cycle, we randomize the move that will occur, using the probabilities we're given. Then, we apply the corresponding operation to each character, and then compare each character against the value which implies a finish. If one or both have crossed the finish line, we break, and then determine the outcome of the race and print it.

The program is simple enough it can be kept as one main function, without having to branch out into classes. I considered modularizing it, but I felt that would complicate the program past what it would need to be. I could have also implemented this using recursion, but I felt like it would be a less readable implementation than using a single while loop.

The biggest thing I learned from this project was the specific syntax for java randomization. I took Java from JHU during undergrad, so I have done a very similar assignment before.

I wouldn't do much differently, other than maybe just some general formatting clean-up. Maybe make a better looking grid

## Implementation

``` java
/*
 * Tortoise and Hare is an implementation of the Tortoise and Hare race from 
 * Aesop's Fables. The program simulates the race between the tortoise and the
 * hare, and determines the winner based on the distance traveled by each animal.
 * 
 * The finish line is 100 units away, and they move at speeds (units/cycle) which 
 * is determined by the following rules: 
 * 
 * Contender | Type of Move | Probability | Result 
 * Tortoise  | Fast Plod    | 50%         | +3 units
 *           | Slow Plod    | 30%         | +1 units
 *           | Slip         | 20%         | -6 units
 * Hare      | Big Hop      | 20%         | +9 units
 *           | Small Hop    | 30%         | +1 units
 *           | Big Slip     | 10%         | -12 units
 *           | Small Slip   | 20%         | -2 units 
 *           | Fall Asleep  | 20%         | 0 units 
 */      
package Project1;

public class TortoiseAndHare {
    /*
     * Program Entry Point
     */
    public static void main(String[] args) { 

        // Declare and Initialize Vars
        int tortoise_position = 1; 
        int hare_position = 1;

        System.out.println("AND THEY'RE OFF!!");

        // Play the game
        while(tortoise_position <= 100 && hare_position <= 100) {
            // Move the tortoise
            int tortoise_move = (int) (Math.random() * 10) + 1;
            if (tortoise_move <= 5) {
                tortoise_position += 3;
            } else if (tortoise_move <= 8) {
                tortoise_position += 1;
            } else {
                tortoise_position -= 6;
            }

            // Move the hare
            int hare_move = (int) (Math.random() * 10) + 1;
            if (hare_move <= 2) {
                hare_position += 9;
            } else if (hare_move <= 5) {
                hare_position += 1;
            } else if (hare_move <= 6) {
                hare_position -= 12;
            } else if (hare_move <= 8) {
                hare_position -= 2;
            } else {
                hare_position += 0;
            }

            if (hare_position < 1) {
                hare_position = 1;
            }

            if (tortoise_position < 1) {
                tortoise_position = 1;
            }

            // Display
            for(int i = 0; i < 100; i++) {
                if (i == tortoise_position && i == hare_position) {
                    System.out.print("OUCH!!!");
                } else if (i == tortoise_position) {
                    System.out.print("T");
                } else if (i == hare_position) {
                    System.out.print("H");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println(); // New line
        } // end while(tortoise_position <= 100 && hare_position <= 100)

        // Determine the winner
        if (tortoise_position >= 100 && hare_position >= 100) {
            System.out.println("It's a tie!");
        } else if (tortoise_position >= 100) {
            System.out.println("TORTOISE WINS!!!");
        } else {
            System.out.println("HARE WINS!!");
        }
    } // end main()
} // end class TortoiseAndHare
```

## Output

```
Script started on 2025-03-02 22:25:45-05:00 [TERM="xterm-256color" TTY="/dev/pts/2" COLUMNS="248" LINES="20"]
[?2004h]0;arkosh@greyskull: ~/repos/601_201/Project1[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/Project1[00m$ java TortoiseAndJ[KHare.java
[?2004l
AND THEY'RE OFF!!
 HT                                                                                                 
  H  T                                                                                              
 T         H                                                                                        
    T    H                                                                                          
     T            H                                                                                 
        T       H                                                                                   
  T           H                                                                                     
     T      H                                                                                       
      T     H                                                                                       
 H       T                                                                                          
 H          T                                                                                       
 H           T                                                                                      
  H             T                                                                                   
           H       T                                                                                
         H          T                                                                               
       H             T                                                                              
        H             T                                                                             
                 H     T                                                                            
                 TH                                                                                 
      H             T                                                                               
    H                T                                                                              
    H                   T                                                                           
     H                   T                                                                          
   H               T                                                                                
    H               T                                                                               
     H                 T                                                                            
   H                      T                                                                         
    H                        T                                                                      
             H                  T                                                                   
              H                    T                                                                
               H                      T                                                             
               H                         T                                                          
               H                          T                                                         
             H                               T                                                      
           H                                    T                                                   
                    H                              T                                                
                     H                              T                                               
                      H                              T                                              
                       H                              T                                             
                       H                               T                                            
                       H                                T                                           
                        H                                T                                          
                                 H                          T                                       
                                  H                   T                                             
                                   H                   T                                            
                                    H                     T                                         
                                    H                        T                                      
                                             H         T                                            
                                           H              T                                         
                                            H              T                                        
                                                     H        T                                     
                                                   H             T                                  
                                                 H                T                                 
                                                          H T                                       
                                              H              T                                      
                                              H               T                                     
                                                       H         T                                  
                                                     H            T                                 
                                                   H                 T                              
                                                            H         T                             
                                                             H           T                          
                                                              H             T                       
                                                              H                T                    
                                                                       H T                          
                                                                     H      T                       
                                                                      H        T                    
                                                                       H T                          
                                                                        H T                         
                                                                      H      T                      
                                                                       H        T                   
                                                                     H             T                
                                                                   H                  T             
                                                                    H                  T            
                                                                     H           T                  
                                                                      H           T                 
                                                                               H     T              
                                                                             H        T             
                                                                              H          T          
                                                                            H               T       
                                                                          H                  T      
                                                                        H                       T   
                                                                                 H                 T
                                                                               H                    
TORTOISE WINS!!!
[?2004h]0;arkosh@greyskull: ~/repos/601_201/Project1[01;32markosh@greyskull[00m:[01;34m~/repos/601_201/Project1[00m$ stop[K[K[K[Kexit
[?2004l
exit

Script done on 2025-03-02 22:26:07-05:00 [COMMAND_EXIT_CODE="0"]
```
