=  K-partite and Bipartite Graph (Multimode Networks Transformations)
Matthieu Totet <matthieu.totet@gmail.com>
2017-01-29

last modified: {docdate}

:icons!:
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]
{nbsp} +

//ST: 'Escape' or 'o' to see all sides, F11 for full screen, 's' for speaker notes

//ST: Author and documentation
== Author and documentation

//ST: !

The Multimode Networks Transformations plugin allows you transform a k-partite graph into a mono-partite graph.

//ST: !

Official page of the plugin: https://gephi.org/plugins/#/plugin/semantic[https://gephi.org/plugins/#/plugin/semantic]

Plugin Author: https://github.com/jaroslav-kuchar[Jaroslav Kuchar]

Plugin sources: https://github.com/totetmatt/gephi-plugins/tree/multimode-network[https://github.com/totetmatt/gephi-plugins/tree/multimode-network]

Licensed under: GNU GENERAL PUBLIC LICENSE


== K-partite, Bipartite … What is it ?

//ST: K-partite, Bipartite … What is it ?

Most of the time, when you create a graph, all the nodes are representing the same « kind » of object.

*   In a Social Network: Persons
*   In a Route Network: Bus Stops, Airports, Stations etc…
*   In a Geographical Network: Countries

//ST: !

But sometimes, you will encounter graphs that will have 2, 3 or multiple « kinds » of nodes where the links are almost exclusively going from one type to the other.
These
graphs are called **Multipartite Graphs** :

//ST: !

* If you have **2** kinds of nodes, it’s a **Bi**partite Graph (or **2**-partite)
** Example : Social Network : Persons < - > Companies

//ST: !

* If you have **3** kinds of nodes it’s a** 3**-partite Graph
** Example : Movie Network : Actors < - > Movies < - > Movie Companies

//ST: !

* If you have **k** kinds of nodes it’s a **k**-partite Graph

//ST: !

If you want a proper scientific definition, you can check the https://en.wikipedia.org/wiki/Multipartite_graph[Wikipedia] page about the subject.

== The Dataset

//ST: The dataset

We will use a well known data set : The Cac 40 Administrators relationship from http://www.citoyennumerique.fr/?tag=cac40[www.citoyennumerique.fr.]

The files for Gephi are accessible here : link::../../resources/k-partite-bi-partite.zip[Gexf files]

The tutorial will be based on the **SimpleGraph**, but you also have access to the **FullGraph** to play with.

//ST: !

The CAC 40 represents the 40 most valuable company on the french stock market. A **company** has several **administrators ** and nothing prevent an **administrator** to be in multiple **companies**. So the graph is build such as **companies** are sources of edges and targets are the **administrators**.

//ST: !

This is a typical bi-partite graph. If you look on the data, part of the node has a property type **Administrator** and the other part has a property type **Company**.

image::en/k-partite/k-partite-simple-graph.png[align="center",title="Cac 40 bipartite graph"]
{nbsp} +


//ST: !

We can get quick observations:

*   Filtering by InDegree, we can check that Michel Pebereau and Jean-Martin Folz are in **5 companies** at the same time.
*   Filtering by OutDegree, we can check that St-Gobain and Total have **8 administrators** that are in other companies.

But that could be done without graph, an ordered list on excel would have done the job.

== How to deal with multipartite graphs ?

//ST:!

Having a k-partite graph makes somehow the graph unfriendly to read. Usually, the metrics will be difficult to interpret, and
generating a good visualisation from it won't be trivial.

One method here is to **reduce** the **bi-partite** graph into a **mono-partite** graph.

//ST: !


> By reducing, we will « lose » information but we gain in **readability** and **synthesis**,
> that’s part of the work in data visualisation to see at which level we
> want to go and how to deal with this trade of information. This will
> mostly be driven by the question you want to answer.

//ST: !

The principle of the reduction is to consider a type of **nodes** as **edges** and build a new graph based on this rule.
In our example we have 2 ways to go:

*   Either we decide that the nodes of type « Company  » are the edges. It will generate a "**graph** of **Persons **"
*   Either we decide that the nodes of type « Person  » are the edges. It will generate a "**graph** of **Company **"

//ST: !

> Here both graphs generated makes « sense » (network of
> entities) but it might appear that in some other case, one of the generated graphs won't really be 'interesting'.
>  That’s part of your work to judge this aspect.

Now, how to perform the transformation?

== Using a Plugin

//ST: Using a Plugin

//ST: !

The easiest way is to use the link::https://marketplace.gephi.org/plugin/multimode-networks-transformations-2/[Multimode Network Transformation plugin].
The plugin is available on the Gephi app market and in the plugin manager in Gephi.

//ST: !

image::en/k-partite/k-partite-install-plugin.png[align="center",title="Plugin Install"]
{nbsp} +

//ST: !

When it’s installed, you should be able to see or display the ** Multimode Network Transformation** tab.

//ST: !

Then, load the graph and :

*   Click on **Load Attributes** and select **Type** on **Attribute Type.**
*   For left matrix select **Administrator – Company**  and right matrix **Company – Adminstrator**
*   Enable **Remove Edges** and** Remove Nodes**, and Click** Run

//ST: !

> The plugin will modify directly the graph on the current workspace. If you want to keep the original graph, be sure
> you have copied your workspace.

//ST: !

image::en/k-partite/k-partite-config.png[align="center",title="MultiPartite_Gephi"]
{nbsp} +


//ST: !

The plugins will actually to transform each relation like:

(Administrator)**<-**(Company)**->**(Administrator)

to

(Administrator)**<-[**{weight=Nb of Common Companies}**]->**(Administrator)

Now you should have a graph with only administrators on the graph preview.

//ST: !

image::en/k-partite/k-partite-simple-p2p.png[align="center",title="Tuto_Multi_P2P"]
{nbsp} +


//ST: !

To generate the relation between companies, replay the same steps
from the original graph (duplicate the workspace0 again) and in the **Multimode Network Transformation** use :

*   Left Matrix : Company – Administrator
*   Right Matrix : Administrator – Company

//ST: !

image::en/k-partite/k-partite-config-2.png[align="center",title="MultiPartite_Gephi_2"]
{nbsp} +

//ST: !

image::en/k-partite/k-partite-simple-c2c.png[align="center",title="Tuto_Multi_C2C"]
{nbsp} +

//ST: !

With the 2 new graphs, and playing with the weighted degree of the nodes, we are able to see some particularities:

*   The maximum of **common administrator** between company is **3**: Bouygues and Alstom with Olivier Bouygues, Patrick Kron, Georges Chodron de Courcel
*   **Half of the companies** are sharing at least 2 administrators.
*   The maximum of **common company** between person is **3**: Gerard Lamarche and Paul Demaray Jr see each other in Total, GDF Suez and Lafarge SA.
*   From all administrators that are in at least 2 companies,** 1/3 of them are at least in the _same_ 2 companies**.

//ST: !

Theses statements could have been deduced from the original graph, but now, the information is more visible and accessible, especially if you want to share it to a large public.

//ST: !

> The next steps are now mostly to look at graphs, and summarize all
>  the particularities into some kind of output (poster, interactive graph,
> newspaper etc…)

== Limitations

//ST: Limitations

The plugin works quite well, but sometimes it has some limitation on large graphs. Or sometimes you may want to reduce your graph and have a custom metric computed.
Then the only alternative to that is to use a script that will generate the graph for you.

== Benefits

//ST: Conclusion

Multipartite graphs are complex to analyse, but synthesizing them to lower partite graphs gives you a better vision and insights about your data.

== The end

//ST: The end!

Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
