= Using filters
Clément Levallois <clementlevallois@gmail.com>
2017-02-10

last modified: {docdate}

:icons!:
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:
:sourcedir: ../../../main/java
:github-root: https://github.com/seinecle/gephi-tutorials/blob/master/src/main/asciidoc/

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]

//ST: 'Escape' to see all sides, F11 for full screen

== download a network file for this tutorialhttps://tinyurl.com/gephi-tuto-3
//ST: download a network file for this tutorial

//ST: !

link:../resources/miserables.zip[download this zip file] and unzip it on your computer.

or use this direct link: https://tinyurl.com/gephi-tuto-3[https://tinyurl.com/gephi-tuto-3]

You should find the file `miserables.gexf` in it. Save it in a folder you will remember (or create a folder specially for this small project).

//ST: description of the file / the network
//ST: !

This file contains a network representing "who appears next to whom" in the 19th century novel _Les Misérables_ by Victor Hugofootnote:[D. E. Knuth, The Stanford GraphBase: A Platform for Combinatorial Computing, Addison-Wesley, Reading, MA (1993)].

A link between characters A and B means they appeared on the same page or paragraph in the novel.

The file name ends with ".gexf", which just means this is a text file where the network information is stored (name of the characters, their relations, etc.), following some conventions.


== open the network in Gephi
//ST: open the network in Gephi

//ST: !
- open Gephi. On the Welcome screen that appears,  click on `Open Graph File`
- find `miserables.gexf` on your computer and open it

image::en/gephi-welcome-screen-open-graph-en.png[align="center", title="welcome screen"]

//ST: !
A report window will open, giving you basic info on the network you opened:

image::en/opening-file-report-en.png[align="center", title="report window"]

//ST: !
This tells you that the network comprises 74 characters, connected by 248 links.

Links are undirected, meaning that if A is connected to B, then it is the same as B connected to A.

The report also tells us the graph is not dynamic: it means there is no evolution or chronology, it won't "move in time".

Click on `OK` to see the graph in Gephi.

//ST: !
image::result_miserables.png[align="center",title="The network we will use"]

== getting a sense of the attributes in the data laboratory
//ST: getting a sense of the attributes in the data laboratory

//ST: !
We can switch to the data laboratory to see the underlying data:

image::Switching-to-the-data-laboratory.png[align="center",title="Switching to the data laboratory"]


//ST: !
We see that the nodes of the network have many attributes. In particular, each have a Gender and a measure of how central they are:

image::Nodes-attributes..png[align="center",title="Nodes attributes."]

//ST: !
This is the list of edges (relations) in the network. Notice that they have a "weight" (a "strength").

image::Edges-attributes..png[align="center",title="Edges attributes".]

== discovering the filter panel
//ST: discovering the filter panel

//ST: !
In the overview, make sure the Filter panel is displayed:

image::Making-the-Filter-panel-visible..png[align="center",title="Making the Filter panel visible."]


//ST: !
How the Filter panel works:

image::Workflow-of-filters--size=stretch.png[align="center",title="Workflow of filters", size="stretch"]


//ST: !
An example: hiding edges with weight lower than 2



image::en/filter-edge-weight-1-en.png[align="center",title="Filtering out edges with weight lower than 2."]

{github-root}images/en/filter-edge-weight-en.gif[view online animation] - link: https://tinyurl.com/gephi-tuto-2


//ST: !
When you are finished using a filter in the zone, right click on it and select "remove".

== combining 2 filters
//ST: combining 2 filters

//ST: !
One filter is applied AFTER this other:

*The first filter to be applied is NESTED (placed inside) the second one as a "subfilter"*

Which filter should be placed inside which? Let's look at different examples:

//ST: !
==== 1. Case when the placement of filters makes no difference

//ST: !
Goal: Keeping on screen only the female characters which have a tie (an edge, a relation) of at least strength 2.

-> place the filter "edge weight" inside the filter "Gender":

//ST: !

image::Filter-on-the-Gender-attribute.png[align="center",title="Filter on the Gender attribute"]

//ST: !

image::Filter-on-edge-weight.png[align="center",title="Filter on edge weight"]

//ST: !



image::en/filter-edge-weight-gender-partition1-en.png[align="center",title="Keeping only female characters with at least 2 ties"]

{github-root}images/en/filter-edge-weight-gender-partition-en.gif[view online animation] - link: https://tinyurl.com/gephi-tuto-1

//ST: !
In this case, it was equivalent to:

- nest the "Gender" filter inside the "Edge weight" filter
or
- nest the "Edge weight" filter inside the "Gender" Filter

-> The result was the same (the network on screen is identical in both cases)

//ST: !
==== 2. Case when the placement of filters makes a difference

//ST: !
Here, we want to visualize:

- only the nodes which have *less than* 10 relations  <1>
- and among these, only those which form the "main island" of the network (we want to hide small detached groups of nodes)  <2>

<1> in technical terms, nodes with a `degree` of less than 10.
<2> in technical terms, we are looking for the `giant component`

//ST: !

image::en/filter-degree-range-1-en.png[align="center",title="Filter on degree"]

//ST: !

image::en/filter-giant-component-1-en.png[align="center",title="Filter on giant component"]

//ST: !
We will see that the placement on the filters in the zone will make a difference.

First, let us place the filter on giant component *inside* the filter on degree:

//ST: !

image::en/filter-order-1-en.png[align="center",title="Filters in one configuration"]

//ST: !
In this first case,

- only the giant component of the network was made visible.

-> Since the network was just one big connected "island" to start with, it did not change a thing.

- then, all characters with more than 10 relations where hidden

-> this hides nodes which were connecting with many others, so that we end up with many groups, disconnected from each others.

//ST: !

Now instead, placing the filter degree *inside* the filter on giant component:

image::en/filter-order-2-en.png[align="center",title="Same filters in another configuration"]

//ST: !
In this second case,

- starting from the complete network, all characters with more than 10 relations where deleted.

-> this created a network made of many disconnected groups of nodes

- then the giant component filter is applied,

-> which had for effect to hide small groups, to keep in view only the biggest group of connected nodes.

//ST: !

WARNING: In summary: be careful how you apply several filters at once, this might have an effect on the logic of filtering.

== filter operators
//ST: Filter operators

//ST: !
==== 1. The MASK operator

//ST: !
Imagine you are interested in the female characters of the novel "Les Miserables".

- you are interested in these characters and the relations among them
- you are interested in the relations between female characters and male characters
- you are *not* interested in the relations between male characters

How to make only female characters visible, their relations (to female and male characters) and only those?

//ST: !
The MASK operator applied on the gender partition filter enables you to:

- show all characters
- relations between female characters
- _and relations between male and female characters_
- _but masking male-male relations_

image::en/operator-mask-1-en.png[align="center",title="Using the MASK operator"]

//ST: !
It is also possible to hide / show only some of the directed relations between the visible graph and the filtered out graph:

image::en/operator-mask-2-en.png[align="center",title="Parameters of the MASK operator"]

//ST: !
==== 2. The UNION operator

//ST: !

Imagine you are interested in the characters with names starting with "L" or "J" in "Les Miserables".

How to display only these characters?

//ST: !
We will need to apply filters on the `Label` of the nodes, which contains the names of the characters.

However, looking at the "catalogue" of filters, we see no filter on `Label`. The reason is that `Label` is an internal property of nodes, inaccessible to filters.

So we must first copy the Labels of the nodes in a new attribute, which we will be able to  apply a filter on.

Let's switch to the data laboratory and add this attribute:

//ST: !

image::Adding-a-column-for-Names.png[align="center",title="Adding a column for Names"]


//ST: !

image::Copying-to-this-new-column.png[align="center",title="Copying to this new column"]

//ST: !
We now have an attribute called "Name" that we can find in the Filters:

image::New-filter-available.png[align="center",title="New filter available"]

//ST: !
This is how the filter on Name and its parameters look like in the zone:

image::en/filter-name-1-en.png[align="center",title="Name Filter"]

//ST: !
To recall, we want to show only the characters which name start with "L" or "J". Let's start with the "L" characters.

We need to find the names which match the pattern *`Start with an L`*. The way to describe a pattern in text is called a "regular expression".

Said differently, _a regular expressions (also called "regex") is a convenient way to express a pattern we search for in a text_.

//ST: !
Regular expressions can become very sophisticated. But here, we need just a simple one:

[source,regex]
L.*

Let's examine what the L, the dot and the star mean.

//ST: !

- the letter "L" means we want names starting with this first letter
- . the dot means: any character
- * the star means: the previous character, repeated any time.

So: "select nodes which have a name starting with L, followed by any character"

//ST: !
Please note that you need to check the box "regex":

image::en/filter-name-2-en.png[align="center",title="Using a regular expression in a filter"]

//ST: !
When the filter is applied, only the characters wit a name starting with L will be displayed:

image::en/filter-name-3-en.png[align="center",title="Using a regular expression in a filter"]

//ST: !
How to filter characters with a name starting with the letter "L" or "J"?

We could rely on a more complex regular expression to do this:

[source,regex]
[LJ].*

Meaning: "select nodes which have a name starting with L or J, followed by any characters"

//ST: !
But we can also rely on 2 filters: one for L, one for J. Nesting one inside another would not work, it would mean:

"show nodes which start with an L, and among them, only those which start with a J"

-> no node can meet this condition, so they would all be invisible.

//ST: !
Instead, we should use the *`UNION`* operator that can be found here:

image::en/filter-operator-union-1-en.png[align="center",title="The UNION operator in filters"]

//ST: !
Drag it to the zone, and then drag inside it twice the `Attributes -> Equal -> Name` filter:

image::en/filter-operator-union-2-en.png[align="center",title="The UNION operator and 2 subfilters"]

//ST: !
In the settings of the first Name filter, put the regular expression:
[source,regex]
L.*

In the second Name filter, put:
[source,regex]
J.*

(make sure the "regex" box is checked in both cases)

//ST: !
As a result, the nodes  selected by both filters are added up in the display:

image::en/filter-operator-union-3-en.png[align="center",title="The UNION operator and 2 subfilters"]

//ST: !
==== 3. The NOT operator

//ST: !
The NOT operator flips the result of a filter: what was hidden becomes visible and vice and versa.

//ST: !
Example: if we want to display all characters except for those with a name starting with L or J:

image::en/filter-operator-not-1-en.png[align="center",title="The NOT nodes operator"]

//ST: !
The same result could have been achieved without using the NOT operator. In regular expressions the ^ sign can be used to mean "NOT":

[source,regex]
[^LJ].*

image::en/filter-operator-not-2-en.png[align="center",title="The NOT nodes operator"]

//ST: !
To know more about regular expressions:

http://www.regular-expressions.info/quickstart.html[http://www.regular-expressions.info/quickstart.html]


== more tutorials on using filters in Gephi
//ST: More tutorials on using filters in Gephi

//ST: !

- https://www.youtube.com/watch?v=UrrWA_t1rjc[Video on using filters by Jen Golbeck]

== the end

//ST: The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
