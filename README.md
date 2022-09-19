# <u> Sort Manager Project </u>

## Product specification - 
This application was built under the following specifications: 
- The application will allow a user to build, sort and return a sorted array.
- The user is presented multiple algorithms to choose from 
  - Bubble Sort
  - Merge Sort
  - Tree Sort

- The user will be able to select any of the sorting algorithms
  - When selected, an array is constructed and sorted with the chosen algorithm
  - The user's selection is captured using ```Scanner```
  - The user is prompted to input the size (index positions) of the array
    - This will be captured also using ```Scanner```
  - Once the required information is captured, the program should output:
    - The unsorted array constructed
    - The name of the algorithm chosen
    - The sorted array, following sorting by selected algorithm
    - The time elapsed from start to finish of the sorting algorithm
      - Offer the potential of comparative speed tests
      - Junit testing for functionality testing
- The final product will follow the MVC design pattern
  - Model - The data / functionality
  - View - Returns the data back to the user
  - Controller - Navigates the app, fetching data for the user and presenting it

  
## User walkthrough
When launching the program, the user will be prompted to select numbers 1, 2, 3 OR 4, with further 
expansion that each option represents:
- 1 - Bubble Sort
- 2 - Merge sort
- 3 - Tree Sort
- 4 - All methods compared 

With further instruction that any alternate input, or lack of input, will default
to option 4.
Following on from here, the user will be prompted to input their array size.
Once these requirements have been fulfilled, the selected algorithm will begin
sorting and return both the unsorted and sorted arrays, including length of time
taken to complete sorting. 

As mentioned previously, with the product following the <b> <i>MVC</b> </i> design pattern,
this functionality is obtained through the <i>view</i> and <i>controller</i>.
An example is as follows:
 
#### <u>Controller</u>
At this stage, the user is prompted for their input for their 
algorithm choice and array size.

```java

            Scanner input = new Scanner(System.in);
            view.userInputPrompt();
            String userChoice = input.nextLine();
            view.userIndexPrompt();
            int userIndex = input.nextInt();
            int[] testArr = ArrayBuilder.arrayBuilder(userIndex);
            
            logger.trace("Tracking user input");
            logger.trace(userIndex);
            logger.info(userChoice);
            logger.info(testArr);
```
In the above, the user receives these prompts from the ```view.userInputPrompt()``` 
and ```view.userIndexPrompt()``` methods, which contains messages which are
presented to the user instructing them of the requirements.

### Viewer
As is detailed above, in the snippet below the user is receiving the relevant
information in order to progress forwards.
Following successful entry, the user will be prompted for their required
array size.
#### <u>userInputPrompt()</u>

```java
    public void userInputPrompt() {
        System.out.println("Please select either 1, 2, 3 OR 4.");
        System.out.println("1: bubble sort\n2: Merge sort \n3: Tree sort \n4: Compare all 3 methods on the same array!");
        System.out.println("No input will result in displaying bubble sort on arrays, and then merging them");
    }
```

#### <u>userIndexPrompt() </u>

```java
    public void userIndexPrompt() {
        System.out.println("And finally, please enter in numeric form the number of index positions you'd like");
    }

```

Once the above criteria has been satisfied, both userChoice containing the selected
algorithm and userIndex containing the array size (index positions), the controller will
then begin screening the selected input for appropriate actions going forwards, ensuring the 
correct selection of sorting and array size.
This is as follows: 

### Controller 
On the first line below, we have a call to <b><i><u>ArrayBuilder.arrayBuilder()</b></i></u> with <b><i><u>userIndex</b></i></u>
being passed as a parameter.
As previously discussed, <b><i><u>userIndex</b></i></u> is received from the ```Scanner``` which interacts with
<b><i><u>userIndexPrompt()</b></i></u>.
Once passed to <b><i><u>arrayBuilder()</b></i></u> the method will begin
building an array to the users specified index positions.
```java
            int[] testArr = ArrayBuilder.arrayBuilder(userIndex);

            logger.trace("Tracking user input");
            logger.trace(userIndex);
            logger.info(userChoice);
            logger.info(testArr);
```

The above also contains   ```logger``` which is utilised to capture the user input and further expanded
in our exception handling. This provides an insight into what the user is doing, as well
as any potential negative side effects of the users input.
### <b><i><u>arrayBuilder()</b></i></u>
The arrayBuilder serves as a simple yet effective means of achieving the requirements of
enabling the user to specify their required array size for testing, as well as incorporating 
the ```Random``` class to ensure unbiased selection of numbers for more accurate testing.

```java
public class ArrayBuilder {
    public static int[] arrayBuilder(int index) {
        Random randNum = new Random();
        int[] userTestArray = new int[index];

        for (int i = 0; i < userTestArray.length; i++) {
            userTestArray[i] = randNum.nextInt(10000);
        }
        return userTestArray;
    }
}
```

The above code displays ```index``` being passed as a parameter, which is ```userIndex```
from our controller, containing the index positions specified by the user.
From here, a new ```userTestArrray``` is created, with ```index``` passed for initialization sizing.
The for-loop is utilised for ease of initialization, where it will iterate through the array
until number of iterations is matching the size of the array.
I.E 10,000 iterations for 10,000 index positions.

```java
            if (userChoice != null && userIndex > 0 ){
                if (userChoice.equals("1")) {
                    view.userPrint("Bubble Sort", bSort.sort(testArr), testArr);
                    logger.info(bSort.sort(testArr));
                } else if (userChoice.equals("2")) {
                    view.userPrint("Merge sort", mSort.sort(testArr), testArr);
                    logger.info(mSort.sort(testArr));
                } else if (userChoice.equals("3")) {
                    view.userPrint("Tree sort", tSort.sort((testArr)), testArr);
                    logger.info(tSort.sort(testArr));
                } else {
                    System.out.println(Arrays.toString(testArr));
                    view.userCompareAll("Tree Sort Bubble Sort Merge Sort", tSort.sort(testArr), mSort.sort(testArr), bSort.sort(testArr), testArr);
                }
            } else {
                view.incorrectEntry(userChoice);
                start();
            }
```

Upon successful creation of the users ```testArr``` we then screen the ```userChoice```, 
which provides insight into which algorithm has been selected and is then passed to the relevant ```view```
method for data display to our user.

Again, ```logger``` has been incorporated to track the output of the methods selected and data input 
by the user. This enables an insight into the runnings and usage of the program, as well as any 
issues that may be encountered.

At the bottom of our ```if``` statements, we have an else which effectively serves as screening for incorrect input,
or no input. In the event of either no input, or incorrect input, the user will be prompted to re-select their options
with a reminder as to what the appropriate selections are. 


### ```userPrint()```
The ```userPrint()``` method is contained within the ```view``` class of our MVC design pattern,
taking the users selected method, the sorted array and the un-sorted test array as parameters.

As was discussed in the requirements, the user is required to have access to all data entered and 
formulated when interacting with the program.
As such, the following is returned:
- Method selected
- Sorted array following passing through sorting algorithm
- Unsorted array for comparison purposes


```java
    public void userPrint(String method, int[] result, int[] testArr) {
        System.out.printf("Your %s sorted array is: ", method + Arrays.toString(result) + "." + "\nYour test array was: " + Arrays.toString(testArr));
    }
```

### ```userCompareAll()```
As the specification instructs, the user is required to have the ability to compare the provided
sorting algorithms. This is accomplished inside of the ```userCompareAll()``` method.
This is accomplished through the inclusion of <b><i><u>varargs</b></i></u>, where our sorted arrays and unsorted array
is stored inside of ```2 dimensional array```. This was used as a clean way of introducing multiple
parameters to the same method, without becoming messy.
```java
    public void userCompareAll(String methods, int[]... arrays) {
        System.out.println("Your unsorted array is: " + Arrays.toString(arrays[3]));
        System.out.printf("%s :", methods.substring(0, 9) + " " + Arrays.toString(arrays[0]));
        System.out.printf("\n%s :", methods.substring(10, 21) + " " + Arrays.toString(arrays[1]));
        System.out.printf("\n%s :", methods.substring(22, 32) + " " + Arrays.toString(arrays[2]));
    }
```
With the user only having 3 selections, a ```String``` containing the possible methods was created
and with the ambitions again of not being messy with excessive parameters being passed, was formulated into
one long ```String``` and utilises the ```substring()``` method in order to cut the ```String``` down and obtain
the relevant information for presentation to the user. 


### ...Moving on to how the data is actually formulated and later sorted!

As we've seen  so far, the user has been prompted for their choice between the sorting algorithms,
as well as having been provided the option of selecting all 3 for sake of comparison.
We've seen the user be prompted to enter index positions and inside of the code snippets,
there has been reference to an ```arrayBuilder()``` method.
Lets take a look into ```arrayBuilder()```! 

### arrayBuilder() 
```arrayBuilder(String index)``` is an independent class, in respect of <b><i> Single responsibility </b></i>.
This meaning each class should be tasked with only one job. As a result of this, the  ```userViewer```
provides the prompt which is required to formulate the users ```testArray```.
Once the prompt is received from the  ```UserViewer``` class and appropriate method, the
user then inputs their required array size into the ```userIndex``` variable which is initialized
with the ```Scanner .nextLine()``` method.
This captures the users required index, calls the ```arrayBuilder()```  method and passes the 
user specification through in order to initialize an array matching the user's specifications.
In code, this looks like the following - 

```java
    public static int[] arrayBuilder(int index) {
        Random randNum = new Random();
        int[] userTestArray = new int[index];

        for (int i = 0; i < userTestArray.length; i++) {
            userTestArray[i] = randNum.nextInt(10000);
        }
        return userTestArray;
    }
```

As was explained and visible in the snippet above, the user's specified index positions is passed
and used to instantitate an array of the users specified sizing requirements.
This method utilises the ```Random``` class in order to obtain the numbers required in an easily
accessible and implementable way. 


## The interface! 
As is mentioned in the project requirements, an interface had to be created and implemented across 
all of the sorting algorithms. The specifications were that the interface was to take an
```int[]``` as a parameter and return a sorted ```int[]```.

```java
public interface Sorter {
     int[] sort(int[] arr);
}
```


### The implementation 
In order to stay true and fair, I've only used ```int[]``` in all of my sorting algorithms, holding
an awareness that alternate data structures offered by the ```Collection framework``` provide enhanced efficacy.
This project, however, is most so aimed at the raw efficacy while utilising the same data structures and as such,
was formulated without the usage of more efficient counterparts. 
An example of this being inside of ```TreeSort``` where a dynamically sized ```int[]``` would have been significantly 
more advantageous, such as an ```ArrayList```. This, however, veered away from the raw tests on a specific data structure. 


## BubbleSort
Bubble sort is relatively sraight forwards in its sorting priority structure, we're simply evaluating if the value contained
within ```arr[j - 1]``` is greater in numeric value than the index position which comes after it ```arr[j]```.
In the event that the lower index position holds a larger numeric value, the ```placeholder``` variable is assigned
this value, while the lesser value is assigned to the appropriate index position in order to obtain ascending order.


```java
public int[] sort(int[] arr) {
        try {
            if (arr != null) {
                int placeHolder = 0;
                long start = System.nanoTime();
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 1; j < (arr.length - i); j++) {
                        if (arr[j - 1] > arr[j]) {
                            placeHolder = arr[j - 1];
                            arr[j - 1] = arr[j];
                            arr[j] = placeHolder;
                        }
                    }
                }
                long end = System.nanoTime();
                double ms = (end - start) * 1e-6;
                System.out.println("Bubble sorting Array took: " + (end - start) + "nano seconds" + " Or:  " + ms + " ms");
            }
        } catch (NullPointerException e) {
            logger.error(e.getMessage(), e);
            logger.trace(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error(e.getMessage(), e);
            logger.trace(e.getMessage());
        }
        return Arrays
                .stream(arr)
                .distinct()
                .toArray();
    }
```

While iterating through an array there's always the potential of out of bounds exceptions and as such, I incorporated 
exception handling with this in consideration, alongside ```null``` exception handling in the event nothing was passed to 
the method. 

Finally, in order to remove duplicate entries the ```stream api``` was utilised, with ```distinct``` ensuring only unique
values are contained within the array.

## Merge Sort 
Merge sort is quite a bit more complicated than bubble sort in quite a few ways, although mostly stemming from the division
and resizing of ```arrays```. 

In order to facilitate this, we initially obtain the passed arrays length, dividing it by 2. This provides us our middle
point of the array, and subsequently enables the necessary splitting of the array. 

We have 3 counters, ```i```, ```j``` and ```k``` all of which enable the functionality of our merge sort algorithm.
These counters are incremented under set circumstances, serving as index positions under evaluation when required.



For example, in the first ```while loop``` we evaluate if:
```left[i] < right[j]``` 
And in the event that it is:
```array[k] = left[i]```
else ```right[j]``` would be smaller in numeric value than ```left[i]``` and as such
```array[k] = right[j]```




## TreeSort 
Binary Tree Sort achieves sorting in a different way than the previous two methods and is arguably
the most efficient of the two. 
This is accomplished by creating and storing the input data inside nodes, which are divided 
amongst two sub-trees often appropriately named ```left``` and ```right```.
The ```left``` nodes will always contain values smaller than the node, whereas the ```right``` node will contain the 
values larger than the node.

This is effectively broken down into 3 steps - 
  - Takes elements from input array 
  - Creates a Binary Search Tree by inserting the elements into the tree
  - Conducts in-order traversal in order to ensure correct sorting. 


                




# SortManager
