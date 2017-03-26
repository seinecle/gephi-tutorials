= Using filters
Clément Levallois <clementlevallois@gmail.com>
2017-02-10

last modified: {docdate}

:icons!:
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:
:github-root: https://github.com/seinecle/gephi-tutorials/blob/master/src/main/asciidoc/

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

[.stretch]
image::gephi-logo-2010-transparent.png[width="450" align="center"]


==  'Escape' or 'o' to see all sides, F11 for full screen, 's' for speaker notes

==  download a network file for practice

==  !

link:../resources/miserables.zip[download this zip file] and unzip it on your computer.

or use this direct link: https://tinyurl.com/gephi-tuto-3[https://tinyurl.com/gephi-tuto-3]

You should find the file `miserables.gexf` in it. Save it in a folder you will remember (or create a folder specially for this small project).

==  description of the file / the network
==  !

This file contains a network representing "who appears next to whom" in the 19th century novel _Les Misérables_ by Victor Hugofootnote:[D. E. Knuth, The Stanford GraphBase: A Platform for Combinatorial Computing, Addison-Wesley, Reading, MA (1993)].

A link between characters A and B means they appeared on the same page or paragraph in the novel.

The file name ends with ".gexf", which just means this is a text file where the network information is stored (name of the characters, their relations, etc.), following some conventions.


==  open the network in Gephi

==  !
- open Gephi. On the Welcome screen that appears,  click on `Open Graph File`
- find `miserables.gexf` on your computer and open it

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
We see that the nodes of the network have many attributes. In particular, each have a Gender and a measure of how central they are:

[.stretch]
image::Nodes-attributes..png[align="center",title="Nodes attributes."]


==  !
This is the list of edges (relations) in the network. Notice that they have a "weight" (a "strength").

[.stretch]
image::Edges-attributes..png[align="center",title="Edges attributes".]


==  discovering the filter panel

==  !
In the overview, make sure the Filter panel is displayed:

[.stretch]
image::Making-the-Filter-panel-visible..png[align="center",title="Making the Filter panel visible."]



==  !
How the Filter panel works:

[.stretch]
image::Workflow-of-filters--size=stretch.png[align="center",title="Workflow of filters", size="stretch"]



==  !
An example: hiding edges with weight lower than 2

[.stretch]
image::en/filter-edge-weight-en.gif[align="center",title="How to use filters."]


//PDF: image::en/filter-edge-weight-1-en.png[align="center",title="Filtering out edges with weight lower than 2."]

//PDF: {github-root}images/en/filter-edge-weight-en.gif[view online animation] - link: https://tinyurl.com/gephi-tuto-2


==  !
When you are finished using a filter in the zone, right click on it and select "remove".

==  combining 2 filters

==  !
One filter is applied AFTER this other:

*The first filter to be applied is NESTED (placed inside) the second one as a "subfilter"*

Which filter should be placed inside which? Let's look at different examples:

==  !
==== 1. Case when the placement of filters makes no difference

==  !
Goal: Keeping on screen only the female characters which have a tie (an edge, a relation) of at least strength 2.

-> place the filter "edge weight" inside the filter "Gender":

==  !

[.stretch]
image::Filter-on-the-Gender-attribute.png[align="center",title="Filter on the Gender attribute"]


==  !

[.stretch]
image::Filter-on-edge-weight.png[align="center",title="Filter on edge weight"]


==  !

[.stretch]
image::en/filter-edge-weight-gender-partition-en.gif[align="center",title="Keeping only female characters with at least 2 ties"]


//PDF: image::en/filter-edge-weight-gender-partition1-en.png[align="center",title="Keeping only female characters with at least 2 ties"]

//PDF: {github-root}images/en/filter-edge-weight-gender-partition-en.gif[view online animation] - link: https://tinyurl.com/gephi-tuto-1

==  !
In this case, it was equivalent to:

- nest the "Gender" filter inside the "Edge weight" filter
or
- nest the "Edge weight" filter inside the "Gender" Filter

-> The result was the same (the network on screen is identical in both cases)

==  !
==== 2. Case when the placement of filters makes a difference

==  !
Here, we want to visualize:

- only the nodes which have *less than* 10 relations  <1>
- and among these, only those which form the "main island" of the network (we want to hide small detached groups of nodes)  <2>

<1> in technical terms, nodes with a `degree` of less than 10.
<2> in technical terms, we are looking for the `giant component`

==  !

[.stretch]
image::en/filter-degree-range-1-en.png[align="center",title="Filter on degree"]


==  !

[.stretch]
image::en/filter-giant-component-1-en.png[align="center",title="Filter on giant component"]


==  !
We will see that the placement on the filters in the zone will make a difference.

First, let us place the filter on giant component *inside* the filter on degree:

==  !

[.stretch]
image::en/filter-order-1-en.png[align="center",title="Filters in one configuration"]


==  !
In this first case,

- only the giant component of the network was made visible.

-> Since the network was just one big connected "island" to start with, it did not change a thing.

- then, all characters with more than 10 relations where hidden

-> this hides nodes which were connecting with many others, so that we end up with many groups, disconnected from each others.

==  !

Now instead, placing the filter degree *inside* the filter on giant component:

[.stretch]
image::en/filter-order-2-en.png[align="center",title="Same filters in another configuration"]


==  !
In this second case,

- starting from the complete network, all characters with more than 10 relations where deleted.

-> this created a network made of many disconnected groups of nodes

- then the giant component filter is applied,

-> which had for effect to hide small groups, to keep in view only the biggest group of connected nodes.

==  !

WARNING: In summary: be careful how you apply several filters at once, this might have an effect on the logic of filtering.

==  Filter operators

==  !
==== 1. The MASK operator

==  !
Imagine you are interested in the female characters of the novel "Les Miserables".

- you are interested in female characters and the relations among them
- you are interested in the relations between female characters and male characters
- you are *not* interested in the relations between male characters

How to display this?

==  !
The MASK operator applied on the gender partition filter enables you to:

- show all characters
- relations between female characters
- _and relations between male and female characters_
- _but masking male-male relations_

==  !

[.stretch]
image::en/operator-mask-1-en.png[align="center",title="Using the MASK operator"]


==  !
It is also possible to hide / show only some of the directed relations between the visible graph and the filtered out graph:

[.stretch]
image::en/operator-mask-2-en.png[align="center",title="Parameters of the MASK operator"]


==  !
==== 2. The UNION operator

==  !

Imagine you are interested in the characters with names starting with "L" or "J" in "Les Miserables".

How to display only these characters?

==  !
We will need to apply filters on the `Label` of the nodes, which contains the names of the characters.

However, looking at the "catalogue" of filters, we see no filter on `Label`. The reason is that `Label` is an internal property of nodes, inaccessible to filters.

So we must first copy the Labels of the nodes in a new attribute, which we will be able to  apply a filter on.

Let's switch to the data laboratory and add this attribute:

==  !

[.stretch]
image::Adding-a-column-for-Names.png[align="center",title="Adding a column for Names"]



==  !

[.stretch]
image::Copying-to-this-new-column.png[align="center",title="Copying to this new column"]


==  !
We now have an attribute called "Name" that we can find in the Filters:

[.stretch]
image::New-filter-available.png[align="center",title="New filter available"]


==  !
This is how the filter on Name and its parameters look like in the zone:

[.stretch]
image::en/filter-name-1-en.png[align="center",title="Name Filter"]


==  !
To recall, we want to show only the characters which name start with "L" or "J". Let's start with the "L" characters.

We need to find the names which match the pattern *`Start with an L`*. The way to describe a pattern in text is called a "regular expression".

Said differently, _a regular expressions (also called "regex") is a convenient way to express a pattern we search for in a text_.

==  !
Regular expressions can become very sophisticated. But here, we need just a simple one:

[source,regex]
L.*

Let's examine what the L, the dot and the star mean.

==  !

- the letter "L" means we want names starting with this first letter
- . the dot means: any character
- * the star means: the previous character, repeated any time.

So: "select nodes which have a name starting with L, followed by any character, in any number"

==  !
Please note that you need to check the box "regex":

[.stretch]
image::en/filter-name-2-en.png[align="center",title="Using a regular expression in a filter"]


==  !
When the filter is applied, only the characters wit a name starting with L will be displayed:

[.stretch]
image::en/filter-name-3-en.png[align="center",title="Using a regular expression in a filter"]


==  !
How to filter characters with a name starting with the letter "L" or "J"?

We could rely on a more complex regular expression to do this:

[source,regex]
[LJ].*

Meaning: "select nodes which have a name starting with L or J, followed by any characters"

==  !
But we can also rely on 2 filters: one for L, one for J. Nesting one inside another would not work, it would mean:

"show nodes which start with an L, and among them, only those which start with a J"

-> no node can meet this condition, so they would all be invisible.

==  !
Instead, we should use the *`UNION`* operator that can be found here:

[.stretch]
image::en/filter-operator-union-1-en.png[align="center",title="The UNION operator in filters"]


==  !
Drag it to the zone, and then drag inside it twice the `Attributes -> Equal -> Name` filter:

[.stretch]
image::en/filter-operator-union-2-en.png[align="center",title="The UNION operator and 2 subfilters"]


==  !
In the settings of the first Name filter, put the regular expression:
[source,regex]
L.*

In the second Name filter, put:
[source,regex]
J.*

(make sure the "regex" box is checked in both cases)

==  !
As a result, the nodes  selected by both filters are added up in the display:

[.stretch]
image::en/filter-operator-union-3-en.png[align="center",title="The UNION operator and 2 subfilters"]


==  !
==== 3. The NOT operator

==  !
The NOT operator flips the result of a filter: what was hidden becomes visible and vice and versa.

==  !
Example: if we want to display all characters except for those returned by a UNION on 2 Name filters on L and J initials:

[.stretch]
image::en/filter-operator-not-3-en.png[align="center",title="The NOT nodes operator - 1"]


==  !
Same effect, but applying the NOT operator on single filter using a regex on L or J:

[.stretch]
image::en/filter-operator-not-1-en.png[align="center",title="The NOT nodes operator - 2"]


==  !
Same effect again, achieved without using the NOT operator. In regular expressions the ^ sign inside square brackets means "NOT":

[source,regex]
[^LJ].*

[.stretch]
image::en/filter-operator-not-2-en.png[align="center",title="Achieving a NOT effect with regex"]


==  !
Tutorials about regular expressions:

- http://www.regular-expressions.info/quickstart.html[https://regexone.com/]
- http://www.themacroscope.org/?page_id=643[http://www.themacroscope.org/?page_id=643]

And a web page where you can test your regular expressions: http://regexpal.com[http://regexpal.com]

==  More tutorials on using filters in Gephi

==  !

- https://www.youtube.com/watch?v=UrrWA_t1rjc[Video on using filters by Jen Golbeck]


==  The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
pass:[    <!-- Start of StatCounter Code for Default Guide -->
    <script type="text/javascript">
        var sc_project = 11238920;
        var sc_invisible = 1;
        var sc_security = "8dac6cd5";
        var scJsHost = (("https:" == document.location.protocol) ?
            "https://secure." : "http://www.");
        document.write("<sc" + "ript type='text/javascript' src='" +
            scJsHost +
            "statcounter.com/counter/counter.js'></" + "script>");
    </script>
    <noscript><div class="statcounter"><a title="site stats"
    href="http://statcounter.com/" target="_blank"><img
    class="statcounter"
    src="//c.statcounter.com/11238920/0/8dac6cd5/1/" alt="site
    stats"></a></div></noscript>
    <!-- End of StatCounter Code for Default Guide -->]
