= Importing csv data in Gephi
Clément Levallois <clementlevallois@gmail.com>
2017-02-03

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

== Importing an existing network file
//ST: Importing an existing network file

//ST: !
Gephi handles the import of network files in a variety of formats:

image::network-formats-gephi-import-en.png[align="center",title="file formats supported by Gephi. Source: gephi.org"]
{nbsp} +

//ST: !
To import any of these files, just choose the `File -> Open` menu

==  Importing nodes with labels and their relations: simplest version

//ST: Importing nodes with labels and their relations: simplest version

(looking for the complete, full featured csv import version? <<full-csv-version, skip to here>>.)

//ST: !
The easiest is probably to just have a text file like this one:

----
Source,Target <1>
Jeremy,Jennifer
Valerian,Jeremy
----

<1> This line is mandatory. Don't put a space between the comma and "Target"

Just write this in a text editor and save it as a file `example.txt`

//ST: !

To import this file in Gephi, go to `File->Import Spreadsheet`. Then in the window:

image::Importing-nodes-with-labels-and-their-relations.png[align="center",title="Importing nodes with labels and their relations"]
{nbsp} +

//ST: !
In this window, make sure the box "Create missing nodes" is checked:

image::Second-screen.png[align="center",title="Second screen"]
{nbsp} +

[[full-csv-version]]
//ST: Importing nodes with labels and their relations: full version

//ST: !
Let's look again at the simple text file we used:

....
Source,Target
Jeremy,Jennifer
Valerian,Jeremy
....

There are 2 issues and several missing features, listed below:

//ST: !
==== 1. labels containing commas in them will not work.

Imagine our characters have first names and last names separated by a comma:

Dubois, Jeremy

Rodriguez, Valerian

//ST: !
This will look like:

....
Source,Target
Dubois, Jeremy,Jeremy,Jennifer
Rodriguez, Valerian,Dubois, Jeremy
....

//ST: !

Note that we have 3 commas per line, instead of one!
In this mess, Gephi will not detect where the node labels start and end.
The import will break.

//ST: !
The proper solution is to put node labels inside *double quotes*:

....
Source,Target
"Dubois, Jeremy","Jeremy,Jennifer"
"Rodriguez, Valerian","Dubois, Jeremy"
....

Be careful to use these straight " " double quotes, not the curvy ones: “ ” which French keyboards sometimes have.

//ST: !
==== 2. labels containing double quotes " " in them will not work.

Example: let's imagine that one of our characters has a middle name: Jeremy "Danger" Dubois.
Our text file will look like:
....
Source,Target
"Dubois, Jeremy "Danger"","Jeremy,Jennifer"
"Rodriguez, Valerian","Dubois, Jeremy "Danger""
....

//ST: !
These extra " " will make the Gephi import break:

image::en/import-spreadsheet-4-en.png[align="center",title="The import bugs - the middle name has disappeared"]
{nbsp} +


//ST: !
The solution consists in *adding an extra double quote in front of the double quotes*.
Our text file will look like:
....
Source,Target
"Dubois, Jeremy ""Danger""","Jeremy,Jennifer"
"Rodriguez, Valerian","Dubois, Jeremy ""Danger"""
....

//ST: !
This time, Gephi imports the network correctly:

image::en/import-spreadsheet-3-en.png[align="center",title="Importing node labels containing double quotes"]
{nbsp} +

== Importing more than labels: nodes and edges attributes
//ST: Importing more than labels: nodes and edges attributes

//ST: !
To import attributes we will need to proceed differently.

We need 2 text files: one for the list of nodes, one for the list of relations (edges)

//ST: !

An example file with a list of nodes:
....
Id,Label,Date of Birth,Place of Birth,Years of experience,Rating <1>
3,"Dubois, Jeremy ""Danger""",17/09/1980,"Paris",8,9.27
1,"Jeremy,Jennifer",25/03/1978,"Tampa",8,4.34
45,"Rodriguez, Valerian",30/04/1985,"Berlin",5,6.66
....
<1> Nodes *must* have at least an Id and a Label. Don't put spaces after the commas

//ST: !
An example file with a list of edges:
....
Source,Target,Weight,Type,Where first met <1>
1,45,3,"undirected",London <2>
....
<1> Edges *must* have at least a Source and Target. Other fields are optional.
<2> "undirected", the alternative is "directed". Directed edges have arrow heads.

//ST: !
Let's import the list of nodes first. `File -> Import Spreadsheet`

image::Importing-a-list-of-nodes-with-attributes.png[align="center",title="Importing a list of nodes with attributes"]
{nbsp} +

//ST: !
in the next screen, we must be careful with a couple of things:

image::The-attributes-of-the-nodes.png[align="center",title="The attributes of the nodes"]
{nbsp} +

//ST: !
Then we can import the file with the list of relations. `File -> Import Spreadsheet`

image::Importing-a-list-of-edges-with-attributes.png[align="center",title="Importing a list of edges with attributes"]
{nbsp} +

//ST: !

image::The-attributes-of-the-edges.png[align="center",title="The attributes of the edges"]
{nbsp} +

== Memo card
//ST: Memo card

//ST: !
Nodes

- header must be at least `Id,Label`

//ST: !
Edges

- header must be at least `Source,Target`
- To have an attribute for the "thickness" or "strength" of a relation, this attribute must be called "Weight".
- Want arrows on your links? Add an attribute "Type", with value "Directed"
- Don't wan't arrows? Add an attribute "Type", with value "Undirected"

//ST: !
Types of attributes: which to choose?

image::en/import-spreadsheet-9-en.png[align="center",title="Kinds of attributes"]
{nbsp} +

//ST: !

- Textual attribute: `String`. Nodes sharing the same textual value can be colored the same, or filtered together...
- Numerical attribute: `Integer`, `Double` or `Float`. Nodes can be resized according to their value, or colorized in a gradient. Filters can be applied based on the range of values.
- Boolean attribute: just a `true` or `false` value. Useful for filtering out some nodes which are true or false on some parameter.
- Other types of attributes: not needed for the moment.


== (to be continued)
//ST: (to be continued)


== More tutorials on importing data to Gephi
//ST: More tutorials on importing data to Gephi
//ST: !

- https://github.com/gephi/gephi/wiki/Import-CSV-Data[The Gephi wiki on importing csv]
- https://www.youtube.com/watch?v=3Im7vNRA2ns[Video "How to import a CSV into Gephi" by Jen Golbeck]

== the end

//ST: The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
