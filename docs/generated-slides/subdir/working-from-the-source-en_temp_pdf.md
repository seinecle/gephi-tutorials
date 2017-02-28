= Working from Gephi's source
Clément Levallois <clementlevallois@gmail.com>
2017-02-28

last modified: {docdate}

:icons!:
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:
:sourcedir: ../../../main/java

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]
{nbsp} +

//ST: 'Escape' or 'o' to see all sides, F11 for full screen, 's' for speaker notes

== Presentation of this tutorial
//ST: Presentation of this tutorial

//ST: !
This tutorial explains how to get and modify Gephi's source code, and build Gephi from it.

image::en/developers/use-the-source.jpg[align="center", title="The obligatory meme"]
{nbsp} +

//ST: !
We will:

- download the source code
- run Gephi from the source
- modify Gephi's openGL visualization engine
- run Gephi in this modified version


//ST: !
The modified version of Gephi that we will implement will have for effect to add circles around nodes communities.

This project originates from https://twitter.com/DataToViz/status/828840269072080896[Susie Lu's creation].

We should get something like:

//ST: !

video::Y3jk-_QaFx4[youtube, height=315, width=560, align="center"]

image::en/developers/screenshot-encircling-pdf.png[align="center",title="Circles enclosing communities"]

link to animated version: https://www.youtube.com/watch?v=Y3jk-_QaFx4


//ST: !

For this tutorial you need:

- some knowledge of Java.

- NetBeans installed (https://dl.dropboxusercontent.com/u/28091845/coursera/codapps/session%201/module%201%20-%20installing%20NetBeans%20ans%20Codename%20One%20on%20a%20PC.pdf[up to date instructions here]). Eclipse, IntelliJ or any other code editor won't do.

- a good internet connection since we will download a lot of small dependencies.

- no Github account is necessary (if you have one, fork Gephi before doing all the steps below).


== Downloading the source code
//ST: Downloading the source code

//ST: !

1. Open NetBeans.

2. In NetBeans, go to `Team -> Git -> Clone`

(can't find this menu in NetBeans? read an alternative just below)

//ST: !

image::en/developers/git-clone-gephi-0-en.png[align="center", title="Cloning the gephi source"]
{nbsp} +

//ST: !

NOTE:: if you already have projects opened in NetBeans, the menu Team -> Git -> Clone is replaced by:

 Team -> Remote -> Clone



//ST: !

image::Cloning-the-gephi-source.png[align="center", title="Cloning the gephi source"]
{nbsp} +

//ST: !
- For `Repository URL`, put the address of the Gephi repository on Github, which is:

https://github.com/gephi/gephi.git[https://github.com/gephi/gephi.git]

- for `Clone into`, select a folder on your disk. No need to create a new folder inside, the cloning process will do it.

- Github User and password can be left empty

- Then click on `Next`

//ST: !

image::en/developers/git-clone-gephi-2-en.png[align="center", title="Select Master and click next"]
{nbsp} +


//ST: !
image::en/developers/git-clone-gephi-3-en.png[align="center", title="Leave as it is and click on Finish"]
{nbsp} +

//ST: !
At this step, NetBeans starts downloading the source code of Gephi - not all of it. Should take a couple of minutes, then:

image::en/developers/git-clone-gephi-4-en.png[align="center", title="Click on Open Project"]
{nbsp} +

//ST: !
Select (highlight in blue) the line mentioning Gephi, and click on "Open"

image::en/developers/git-clone-gephi-5-en.png[align="center", title="Click on Open Project"]
{nbsp} +

//ST: !
You should now see Gephi as a project on the left in NetBeans:

image::en/developers/netbeans-gephi-source-1-en.png[align="center", title="Gephi project"]
{nbsp} +

//ST: !
Right click on the project and select "Build with dependencies". This will download all the rest of the source, which can take roughly 5 to 20 minutes.

image::en/developers/netbeans-gephi-source-2-en.png[align="center", title="Building the project"]
{nbsp} +

== Running Gephi from source
//ST: Running Gephi from source

//ST: !
When the build is complete, expand the folder "Modules" of the Gephi project, and double click on "gephi-app":


image::en/developers/netbeans-gephi-source-3-en.png[align="center", title="Opening the gephi-app submodule"]
{nbsp} +
//ST: !
This opens a new project on the left of NetBeans, called "gephi-app". This is a submodule of Gephi, dedicated to managing its launch.

image::Launching-Gephi.png[align="center", title="Launching Gephi"]
{nbsp} +

//ST: !

And Gephi launches!

Now that we know how to run Gephi from source, we can modify the source and see how it goes.

== Modifying Gephi's openGL visualization engine
//ST: Modifying Gephi's openGL visualization engine

//ST: !
We are going to add circles which will enclose groups of nodes (aka communities). In three steps:

1. Open the `VisualizationImpl` module
2. Create simple classes for the circles
3. Add some code in the class which manages the display in OpenGL, so that circles get created

//ST: !
==== 1. Open the `VisualizationImpl` module

In the gephi project, in the folder Modules, double click on the `VisualizationImpl` module:


image::en/developers/enclosing-circles-1-en.png[align="center", title="Opening VisualizationImpl"]
{nbsp} +

//ST: !
==== 2. Create simple classes for the circles

Create a new package and add 3 classes in it: `Circle.java`, `Point.java`, `SmallestEnclosingCircle.java`.

(I merely adapted these classes from https://www.nayuki.io/page/smallest-enclosing-circle[this website])

image::en/developers/enclosing-circles-2-en.png[align="center", title="Three classes"]
{nbsp} +

//ST: !
The code of these classes https://github.com/seinecle/gephi/tree/enclosing-circles-opengl/modules/VisualizationImpl/src/main/java/net/clementlevallois/enclosingcircles[can be found here].

//ST: !
==== 3. Add the circle creation logic to the class managing the OpenGL display

Open the package `org.gephi.visualization.opengl`, and inside open `CompatibilityEngine.java`:

image::opening-CompatibilityEngine.java.png[align="center", title="opening CompatibilityEngine.java"]
{nbsp} +

//ST: !
No need to understand most of the code in this class.

But we see that starting at https://github.com/seinecle/gephi/blob/enclosing-circles-opengl/modules/VisualizationImpl/src/main/java/org/gephi/visualization/opengl/CompatibilityEngine.java#L194[line 194], a loop on nodes starts:

We will put nodes in a map (declared above, at https://github.com/seinecle/gephi/blob/enclosing-circles-opengl/modules/VisualizationImpl/src/main/java/org/gephi/visualization/opengl/CompatibilityEngine.java#L155[line 155]) where:

- keys are the name of the cluster nodes belong too,
- values are the Set of Nodes corresponding to the cluster.

(yes, this implies the nodes must have an attribute called "Modularity Class" showing the cluster they belong to)

//ST: !
The code you should add to assign nodes to clusters in the map is in https://github.com/seinecle/gephi/blob/enclosing-circles-opengl/modules/VisualizationImpl/src/main/java/org/gephi/visualization/opengl/CompatibilityEngine.java#L197[lines 197-203]

//ST: !

Then, https://github.com/seinecle/gephi/blob/enclosing-circles-opengl/modules/VisualizationImpl/src/main/java/org/gephi/visualization/opengl/CompatibilityEngine.java#L210[lines 210-245] iterate on the map, and create the circles around clusters.

The logic of the circle creation in OpenGL can be understood rather easily, by copying and modyfying the code used just above for the creation of nodes, and by looking at the online documentation on http://www.openglprojects.in/2014/03/draw-circle-opengl.html#gsc.tab=0[how to create shapes in OpenGL].

//ST: !
That's it. Now just run Gephi from source as we did before. From Gephi, open a network where nodes have a "Modularity Class" attribute, and Gephi will draw circles around nodes from the same clusters:

//ST: !

video::Y3jk-_QaFx4[youtube, height=315, width=560, align="center"]

== More tutorials on using the source code of Gephi
//ST: More tutorials on using the source code of Gephi
//ST: !

- https://github.com/gephi/gephi[The Gephi readme with some instructions for developers]

== the end

//ST: The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
