= Finding the right toolchain to work on open documents
Clément Levallois <clementlevallois@gmail.com>
2017-01-04
:revnumber: 1.0
:example-caption!:

The source of this document (written in asciiDoc) is available on https://github.com/seinecle/blog/blob/master/src/main/asciidoc/05-01-2017-1.adoc[on Github].
The pdf, html and slide versions of this document are also on https://github.com/seinecle/blog/tree/master/target[Github].



== The goal

I'd like to be able to write my courses and tutorials in one document, then convert them to slides / pdfs / ebooks / web pages at the click of a button.
On a second button click, I'd like these docs to be uploaded on the web to make them open access, versionable and fit for multi-authoring.

== !

image::A-diagram-showing-the-authoring-steps-to-create-open--web-friendly-docs.png[align="center", title="A diagram showing the authoring steps to create open, web friendly docs"]


== Introduction
In the previous blog post, I presented asciidoc as a promising technology to create easily open courses and tutorials.
It allows to write clean, minimum text files which then convert to web pages, pdf, ebooks and slides at a click of a button.

== Which tools to work on AsciiDocs?
Just like you can write Word documents in MS Word or in Open Office, many tools exist to work on asciidoc.
I am still trying to figure out which one would best fit my needs. Because I program in Java, I looked at Java-based solutions because I can more easily adapt them to my needs.


== AsciiDocFX?
I tried first http://asciidocfx.com/[AsciiDocFX], based on the emerging https://en.wikipedia.org/wiki/JavaFX[JavaFX technology]. You can install it easily for Mac, Windows and Linux. Try it!
The great part is that you have an instant preview in html or slides, as you type.

== Not choosing AsciiDocFX
Remember I want to embed pics and diagrams from Google Drawings into my docs? These pics have weird links like:
https://docs.google.com/drawings/d/1j00khDpGCzHQNvtJMwr6W52yhgslnLWvQgXwuNUAtZo/pub?w=450
which are not processed easily by AsciiDocFX.

== Workaround
A workaround is to first download the content of the web link as a file, then embed this file into the asciidoc.
I could not figure how to manage this from AsciiDocFX. It made me fear that AsciidocFX was too hard to customize, so I searched for a more flexible solution.


== AsciidoctorJ?
This is another Java version of the tools used to convert an asciidoc into web pages, pdf and the rest.
https://github.com/asciidoctor/asciidoctorj[AsciiDocJ] is not a software you install, this is a programming tool to be used in a programming environment.

== Benefits and inconvenients of AsciiDoc
- I can use it from http://netbeans.org/[NetBeans], which is my favorite programming editor
- Much less user friendly than AsciiDocFX (no preview of your docs), but I could live with that.
- Provides full flexibility to manipulate the documents, by using code.

== Example: Managing web pics with AsciiDocJ
Web based pics can't be embedded in my doc?
No problem, I can write some additional code which scans my doc, finds these web links and apply the necessary steps to make them right.
I am more confident that other bumps on the road of processing the conversion of docs (footnotes in books? transitions in slides? custom styling?) can be dealt with.


== Next steps
AsciiDocJ is configured through https://maven.apache.org/[Maven] rather than in pure java code. Maven is a protocol written in Java to customize the assembly of the files of a project: zipping them, sending them to a server, executing them...
The trick is, Maven is configured through a quite complex XML file. I need some time to get acquainted to that.
If you read this post in html, slides, or pdf form this means I've made some progresses!
