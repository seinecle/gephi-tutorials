=  Converting a network with dates into a dynamic network
Clément Levallois <clementlevallois@gmail.com>
2017-02-17

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

- We take a normal network, where nodes have attributes which can serve as time indication (a date, a number...)
- We convert this network into a dynamic network: nodes will appear and disappear according to their attributes.

==  download a network file for practice

==  !

link:../../resources/miserables-with-dates.zip[download this zip file] and unzip it on your computer.

or use this direct link: https://tinyurl.com/gephi-tuto-4[https://tinyurl.com/gephi-tuto-4]

==  !

You should find the file `miserables-with-dates.gexf` in the zip file. Save it in a folder you will remember (or create a folder specially for this small project).

==  description of the file / the network
==  !

This file contains a network representing "who appears next to whom" in the 19th century novel _Les Misérables_ by Victor Hugofootnote:[D. E. Knuth, The Stanford GraphBase: A Platform for Combinatorial Computing, Addison-Wesley, Reading, MA (1993)].

A link between characters A and B means they appeared on the same page or paragraph in the novel.

The file name ends with ".gexf", which just means this is a text file where the network information is stored (name of the characters, their relations, etc.), following some conventions.

==  !
This file has been modified to add some dates to each character in the novel:

- a "start date", which is a day (example: 22/09/1835). This is the date when the character *enters* the action in the novel
- an "end date", also a day (example: 22/09/1840). This is the date when the character *leaves* the action in the novel
- a "peak moment". This is a number (example: 14263). This is an instant when the character is at the center of the plot. This number has no historical meaning, this is just a chronological moment in time.

==  !

NOTE:: Values for start date, end date and peak moment have no real significance in the novel. They are made up for this exercise.

==  open the network in Gephi

==  !
- open Gephi. On the Welcome screen that appears,  click on `Open Graph File`
- find `miserables-with-dates.gexf` on your computer and open it

[.stretch]
image::en/gephi-welcome-screen-open-graph-en.png[align="center", title="welcome screen"]


==  !
A report window will open, giving you basic info on the network you opened:

[.stretch]
image::en/opening-file-report-en.png[align="center", title="report window"]


==  !
This tells you that the network comprises 74 characters, connected by 248 links.

Links are undirected, meaning that if A is connected to B, then it is the same as B connected to A.

The report also tells us the graph is not dynamic: it means there is no evolution or chronology, it won't "move in time".

Click on `OK` to see the graph in Gephi.

==  !
[.stretch]
image::result_miserables.png[align="center",title="The network we will use"]


==  getting a sense of the attributes in the data laboratory

==  !
We can switch to the data laboratory to see the underlying data:

[.stretch]
image::Switching-to-the-data-laboratory.png[align="center",title="Switching to the data laboratory"]



==  !

[.stretch]
image::Zoom-on-three-attributes-representing-time.png[align="center",title="Zoom on three attributes representing time"]



==  !
The nodes (characters) of the network have attributes (start date, end date, peak moment) which can make this graph dynamic - but it is not yet.

A couple of steps are needed to enable the dynamic features, and here a choice must be made:

==  !

Do we prefer to have...

1. ... nodes appearing on screen at their start date, and staying on screen for ever after?
2. ... nodes appearing on screen at their start date, and leaving the screen at their end date?
3. ... nodes being representedsimply by their "peak moment" (a number), without reference to chronological dates?

We will present these 3 possibilities.

==  !
==== 1. dynamic nodes with a start date

==  !

[.stretch]
image::Merge-columns.png[align="center",title="Merge columns"]


==  !

[.stretch]
image::Set-up-the-parameters---1.png[align="center",title="Set up the parameters - 1"]


==  !

[.stretch]
image::Result.png[align="center",title="Result"]



==  !
Let's switch back to the Overview to see the graph and how it evolves in time.

IMPORTANT:: We are going to use the timeline to play the animation. The timeline has many features which are explained in a specific tutorial.

==  !

[.stretch]
image::moving-timeline-miserables-1-en.gif[align="center",title="Animating the dynamic network"]


//PDF: image::moving-timeline-miserables-2-en.png[align="center",title="Animating the dynamic network"]

//PDF: {github-root}images/moving-timeline-miserables-1-en.gif[view online animation] - link: https://tinyurl.com/gephi-tuto-5


==  to be continued


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
