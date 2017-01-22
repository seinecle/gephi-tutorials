= Simple Gephi Project from A to Z
Clément Levallois <clementlevallois@gmail.com>
2017-01-20

last modified: {docdate}

:revnumber: 1.0
:example-caption!:

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]

== Description of the project

//ST: Description of the project
This project is for complete beginners to Gephi.
It supposes you have Gephi installed and running on your computer. That is all.

When finishing this tutorial, you should be able to:
[options="compact"]
- understand the vocabulary to discuss networks
- download a network file for this exercise
- description of the file / the network
- open a network file
- read the report after opening a file
- show the labels of the nodes
- layout the network
- visualize attributes of the network
- compute the centrality of the nodes in the network
- visualize attributes created by Gephi
- export a visualization as a picture or pdf


== know the terminology to discuss networks

//ST: !
image::terminology-for-networks.png[align="center",title="terminology for networks"]


== download a network file

//ST: download a network file
link:../resources/miserables.zip[download this zip file] and unzip it on your computer.

You should find the file `miserables.gexf` in it.

Save it in a folder you will remember (or create a folder specially for this small project).

== description of the file / the network

//ST: description of the file / the network

This file contains a network representing "who appears next to whom" in the 19th century novel _Les Misérables_ by Victor Hugofootnote:[D. E. Knuth, The Stanford GraphBase: A Platform for Combinatorial Computing, Addison-Wesley, Reading, MA (1993)].

A link between characters A and B means they appeared on the same page or paragraph in the novel.

The file name ends with ".gexf", which just means this is a text file where the network information is stored (name of the characters, their relations, etc.), following some conventions.


== open the network

//ST: !
- open Gephi. On the Welcome screen that appears,  click on `Open Graph File`
- find `miserables.gexf` on your computer and open it

image::en/gephi-welcome-screen-open-graph-en.png[align="center", title="welcome screen"]

== read the report after opening a file

//ST: !
A report window will open, giving you basic info on the network you opened:

image::en/opening-file-report-en.png[align="center", title="report window"]

//ST: !
This tells you that the network comprises 74 characters, connected by 248 links.

Links are undirected, meaning that if A is connected to B, then it is the same as B connected to A.

The report also tells us the graph is not dynamic: it means there is no evolution or chronology, it won't "move in time".

Click on `OK` to see the graph in Gephi.

== initial view

//ST: !

image::en/project-initial-view.png[align="center", title="initial view when opening a graph"]

This is how the network appears in Gephi. Not very useful! Let's examine what we have here.

== basic view of Gephi's interface

//ST: !
image::the-3-main-screens-in-Gephi.png[align="center", title="the 3 main screens in Gephi"]

//ST: !
Gephi has 3 main screens:

1. Overview: where we can explore the graph visually
2. Data Laboratory: provides an "Excel" table view of the data in network
3. Preview: where we polish the visualization before exporting it as a pictue or pdf

What we see here is the Overview.

//ST: !

image::Filters-and-statistics-panels-in-Gephi.png[align="center", title="Filters and statistics panels in Gephi"]

//ST: !
In the Overview, the graph is shown at the center. Around it, several panels help us fine tune the visualization.
[options="compact"]
[start=4]
4. "Filters", where we can hide different parts of the network under a variety of conditions
5. "Statistics", where we can compute metrics on the network

//ST: !
image::Appearance-and-layout-panels-in-Gephi.png[align="center", title="Appearance and layout panels in Gephi"]


//ST: !
[options="compact"]
[start=6]
6. "Appearance", where we can change colors and sizes in interesting ways
7. "Layouts", where we can apply automated procedures to change the position of the network

//ST: !
image::3-groups-of-icons.png[align="center", title="3 groups of icons"]

//ST: !

[options="compact"]
[start=8]
8. A series of icons to add / colorize nodes and links manually, by cliking on them
9. Options and sliders to change the size of all nodes, links, or labels
10. More options become visible if we click on this *little arrow head pointing up*


== showing labels of the nodes

//ST: !

image::showing-node-labels.png[align="center", title="showing node labels"]


== layout ("spatialize") the network

//ST: !

image::selecting-the-force-atlas-2-layout.png[align="center", title="selecting the force atlas 2 layout"]

//ST: !

image::changing-a-few-parameters-and-launching-the-layout.png[align="center", title="changing a few parameters and launching the layout"]


//ST: !

image::result-of-Force-Atlas-2-layout.png[align="center", title="result of Force Atlas 2 layout"]




== (to be continued)

//ST: (to be continued)


== questions and exercises

//ST: questions and exercises

//ST: !
1. Open the file `miserables.gexf` with a text editor (here is how to do it on a http://www.dummies.com/computers/macs/how-to-open-and-edit-a-text-file-on-a-mac/[Mac], and on https://www.microsoft.com/resources/documentation/windows/xp/all/proddocs/en-us/app_notepad.mspx?mfr=true[Windows]). See how the nodes and the links are written in the file. Can you find the character Javert?

//ST: !
[start=2]
2. Our network of Les Miserables characters was undirected. Can you think of networks which are directed?

Imagine how undirected and directed networks differ when computing centrality, for example.

//ST: !
[start=3]
3. Force Atlas 2 is a layout which brings together connected node, and spreads out unconnected nodes. What will happen to the nodes wich have no relation at all with other nodes (called "isolated nodes").

How will these isolated nodes move on screen?

//ST: !
[start=4]
4. When applying the Force Atlas 2 layout, the network moves quickly, then stabilizes, and then keeps moving a bit.

Can you guess why this is happening?

//ST: !
[start=5]
5. In the list of layouts, Force Atlas 2 is just one of many options you can choose.
Try "Fruchterman Reingold" and "Yfan Hu".

These are layouts which follow the same logic as Force Atlas 2, but with slight variations. Explore how these algorithms result in similar, yet specific layouts.
