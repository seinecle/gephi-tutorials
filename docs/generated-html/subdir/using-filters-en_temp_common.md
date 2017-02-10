= Using filters
Clément Levallois <clementlevallois@gmail.com>
2017-02-10

last modified: {docdate}

:icons!:
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:
:sourcedir: ../../../main/java

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]

//ST: 'Escape' to see all sides, F11 for full screen

== Download a network file for this tutorial
//ST: Download a network file for this tutorial

//ST: !

link:../resources/miserables.zip[download this zip file] and unzip it on your computer.

You should find the file `miserables.gexf` in it.

Save it in a folder you will remember (or create a folder specially for this small project).

//ST: description of the file / the network
//ST: !

This file contains a network representing "who appears next to whom" in the 19th century novel _Les Misérables_ by Victor Hugofootnote:[D. E. Knuth, The Stanford GraphBase: A Platform for Combinatorial Computing, Addison-Wesley, Reading, MA (1993)].

A link between characters A and B means they appeared on the same page or paragraph in the novel.

The file name ends with ".gexf", which just means this is a text file where the network information is stored (name of the characters, their relations, etc.), following some conventions.


== open the network in Gephi
//open the network in Gephi
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

//ST: !
image::result_miserables.png[align="center",title="The network we will use in this tutorial"]

//ST: !
We can switch to the data laboratory to see the underlying data:

image::Switching-the-view-to-the-data-laboratory.png[align="center",title="Switching the view to the data laboratory"]


//ST: !
We see that the nodes of the network have many attributes. In particular, each have a Gender and a measure of how central they are:

image::Nodes-attributes..png[align="center",title="Nodes attributes."]

//ST: !
This is the list of edges (relations) in the network. Notice that they have a "weight" (a "strength").

image::Edges-attributes..png[align="center",title="Edges attributes".]


//ST: !
In the overview, make sure the Filter panel is displayed:

image::Making-the-Filter-panel-visible..png[align="center",title="Making the Filter panel visible."]






== (to be continued)
//ST: (to be continued)


== More tutorials on importing data to Gephi
//ST: More tutorials on importing data to Gephi
//ST: !

- https://www.youtube.com/watch?v=UrrWA_t1rjc[Video on using filters by Jen Golbeck]

== the end

//ST: The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
