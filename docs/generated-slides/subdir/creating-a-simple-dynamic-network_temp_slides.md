=  Creating a simple dynamic network
Clément Levallois <clementlevallois@gmail.com>
2017-02-16

last modified: {docdate}

:icons: font
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:
:experimental:
:github-root: https://github.com/seinecle/gephi-tutorials/blob/master/src/main/asciidoc/

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

[.stretch]
image::gephi-logo-2010-transparent.png[width="450" align="center"]


==  'Escape' or 'o' to see all sides, F11 for full screen, 's' for speaker notes

==  Goals of this tutorial

==  !

- We are going to create one very simple *non dynamic* network (network "A").
- then we will create a modified version of it (network "B").
- in both files, we need to modify a single line.
- finally, we will merge networks A and B, forming a new *dynamic* network evolving from version A to B.

==  !
[NOTE]
====
The creation of the 2 networks is not a mandatory step: you can use your own network files, as long as they are in gexf file format. In this case, <<merging, skip to here>>.

We create the networks in this tutorial to provide the most simple and clear case.
====

==  open a new project in Gephi

==  !
- open Gephi. On the Welcome screen that appears,  click on `New Project`

[.stretch]
image::Open-a-new-project.png[align="center", title="Open a new project"]


==  creating network "A"

==  !
Our project is empty.
We can use a simple click-and-point tool to create a network:

[.stretch]
image::Icon-for-node-creation.png[align="center", title="Icon for node creation"]


==  !

[.stretch]
image::A-few-nodes-have-been-created.png[align="center", title="A few nodes have been created"]


==  !
When you have created a couple of nodes, click again on the pencil icon to stop the node creation.

Export the network as a file and call it "network A":

==  !

[.stretch]
image::Exporting-the-network.png[align="center", title="Exporting the network"]


==  !

[.stretch]
image::Choosing-the-gexf-file-format.png[align="center", title="Choosing the gexf file format"]


==  !
Clicking on "Save" saves the file in the folder you chose. You are back to the view on your graph.

==  creating network "B"

==  !

Now, click on the "Edge pencil", just below the "Node pencil we have used (careful, the icons are identical!)

==  !

[.stretch]
image::Choosing-the-gexf-file-format.png[align="center", title="Choosing the gexf file format"]


Create one edge, or a couple of edges, in this way.

==  !

Clicking again on the pencil stops the edge creation by mouse clicks.

Then export the network *in the same folder* where we put the previous file (`File -> Export -> Graph File ...`)

*This time, name the file 'network B.gexf' and remember to choose the `gexf` file format just like we did before.*

==  modifying just one line in the files network A.gexf and network B.gexf

==  !
[[merging]]
From your computer, open network A.gexf with a text editor (don't use Microsoft Word!):

(here is how to do it on a http://www.dummies.com/computers/macs/how-to-open-and-edit-a-text-file-on-a-mac/[Mac], and on https://www.microsoft.com/resources/documentation/windows/xp/all/proddocs/en-us/app_notepad.mspx?mfr=true[Windows]).

==  !
[.stretch]
image::The-network-file-opened.png[align="center", title="The network file opened"]


==  !
Delete and replace this line by this one:

==  !

[source,xml]
----
<graph mode="slice" defaultedgetype="directed" timerepresentation="timestamp" timestamp="1">
----
See `timestamp="1"` ? It means this will be the first "time slice" of your dynamic network.

Save the file.

==  !
Repeat the steps for network B.gexf:

- open the file in a text editor,
- find the  line `<graph defaultedgetype="directed" mode="static">`
- replace it by:

[source,xml]
----
<graph mode="slice" defaultedgetype="directed" timerepresentation="timestamp" timestamp="2">
----

(see that we have *`timestamp="2"`* here: this is going to be the second time slice!)

- save the file.

==  merging network "A" and "B" into a dynamic network

==  !
We will use the 2 files network A.gexf and network B.gexf that we have created.

First, let's close the project we have in Gephi, without saving:

==  !

[.stretch]
image::Closing-the-current-project.png[align="center", title="Closing the current project"]


==  !
Then click on `File -> Open` and navigate to the folder where network A.gexf and network B.gexf are located:

[.stretch]
image::Opening-files.png[align="center", title="Opening files"]


==  !
Here, make sure you select the *2 files at once* (using the key kbd:[Ctrl] on pc or kbd:[{commandkey}] on mac).

[.stretch]
image::Opening-2-files-at-once.png[align="center", title="Opening 2 files at once"]


==  !
Opening the files display a report window:

[.stretch]
image::Import-report-window.png[align="center", title="Import report window"]



==  enabling the timeline

==  !
You should see this button, click on it (if not: something went wrong. Retrace your steps)

[.stretch]
image::Enable-the-timeline.png[align="center", title="Enable the timeline"]


==  !
Click and slide the right side border of the timeline *to the left*. You should see the edge disappear:

[.stretch]
image::Sliding-the-timeline.png[align="center", title="Sliding the timeline"]


==  !
We created a dynamic network.
It needs to be animated precisely with the timeline, dynamic attributes should be explored, as well as dynamic layouts.

These features will be explained in the coming tutorials on dynamic networks with Gephi.

==  more tutorials on dynamic networks with Gephi

==  !

- https://github.com/gephi/gephi/wiki/Import-Dynamic-Data[The wiki on gephi.org]


==  The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
pass:[    <!-- Start of StatCounter Code for Default Guide -->
    <script type="text/javascript">
        var sc_project = 11238920;
        var sc_invisible = 1;
        var sc_security = "11238920";
        var scJsHost = (("https:" == document.location.protocol) ?
            "https://secure." : "http://www.");
        document.write("<sc" + "ript type='text/javascript' src='" +
            scJsHost +
            "statcounter.com/counter/counter.js'></" + "script>");
    </script>
    <noscript><div class="statcounter"><a title="site stats"
    href="http://statcounter.com/" target="_blank"><img
    class="statcounter"
    src="//c.statcounter.com/11238920/0/11238920/1/" alt="site
    stats"></a></div></noscript>
    <!-- End of StatCounter Code for Default Guide -->]
