= Importing data in Gephi
Clément Levallois <clementlevallois@gmail.com>
2017-02-03

last modified: {docdate}

:icons!:
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]



== Simplest case: you already have a network file (gdf, gexf, etc.)

== !
Gephi handles the import of network files in a variety of formats:

image::network-formats-gephi-import-en.png[align="center",title="file formats supported by Gephi. Source: gephi.org"]

== !
To import any of these files, just choose the `File -> Open` menu


== Importing nodes with labels and their relations

== !
The easiest is probably to just have a text file like this one:

....
Source,Target <1>
Jeremy,Jennifer
Valerian,Jeremy
....
<1>This line is mandatory. Don't put a space between the comma and "Target"

Just write this in a text editor and save it as a file `example.txt`

== !

To import this file in Gephi, go to `File->Import Spreadsheet`. Then in the window:

image::Importing-nodes-with-labels-and-their-relations.png[align="center",title="Importing nodes with labels and their relations"]

== !
In this window, make sure the box "Create missing nodes" is checked:

image::Second-screen.png[align="center",title="Second screen"]


== (to be continued))


== More tutorials on importing data to Gephi
== !

- https://github.com/gephi/gephi/wiki/Import-CSV-Data[The Gephi wiki on importing csv]


== The end!
Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
