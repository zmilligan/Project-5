# Project 5

**Thought Process:**
* The first thing that I did was go through the previous projects to get all the needed methods for my HammingDist class. I adjusted them as needed to work together in one class. 
* I started out with the GUI portion by simply creating all of the variables that I would need.
	* First I created set__ methods to section out the fields by type.
	* Inside those methods, I initialized all the variables that I would need, not worrying about anything other than creating them.
	* I then went section by section - first JSlider, then JButtons, JTextFields, JLables, and finally the drop-down box - and gave them their necessary characteristics. For example, I gave the labels and buttons their correct titles, set the slider constraints, and set the applicable text fields to be uneditable.
	*Then I created the two panels I would need - one for the required stuff, the other for my personal stuff.
* Once I was sure I had everything that I would need, I created my frame and set the size and default close operation, added grid layout with two columns, and added my two panels.
* In the main method, I created a new object so that I could open and interact with the frame.
* Then I worked on adding the components to the panel.
	* First, I added a gridbaglayout manager and made a gridbagconstraints object.
	* I read the API extensively so that I would know how to use these objects.
	* I fiddled around a lot longer than I would have liked figuring out how to get the right layout.
* Then I started working on the interactive components
	* First I did the slider to get it to change the hamming distance text field above it.
	* I then added action listeners to the buttons that affected the other text fields.
* At this point I made a lot of mistakes because I created new classes to separate the panels. I decided to use an abstract class and separate the frame and main into another class.
* I decided that I wanted to have my personal part deal with the ASCII values
*As such, I edited HammingDist with methods from project 2.
* I started the process listed above to make my panel. However, I realized that I needed to access info from the other panel and so I had to scrap some classes and combine the two panels into one class. It was a mess.
* Eventually I was able to figure it out and continue with the process.
* Once I had everything I needed, I tested all of the GUI elements by messing around with all the elements.


**Analysis of Code:**
* The HammingDist class has no completely original methods because I grabbed them from my code from other projects. I had to adjust them to ensure that I could access and modify as necessary from a HammingDist object as opposed to the class.
* In Project5Panels I used the same set___ methods for the components of both panels. This helped to save space and did not significantly decrease the readability of the class.
* Because I used a separate class for the frame and main method, I created accessor methods for the two panels.
