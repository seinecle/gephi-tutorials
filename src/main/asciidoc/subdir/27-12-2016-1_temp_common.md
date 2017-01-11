:forceinclude:
= Authoring open, web-friendly courses and tutorials

by Clément Levallois (http://www.twitter.com/seinecle[@seinecle]), first version 27/12/2016

_To make my point early on: this document is written in AsciiDoc, which converts easily into
https://github.com/seinecle/blog/blob/master/blog%20post%2027-12-2016.pdf[pdf],  https://rawgit.com/seinecle/blog/master/blog%20post%2027-12-2016.html[html] and https://rawgit.com/seinecle/blog/master/blog%20post%2027-12-2016.epub[epub] versions and online slides as well._

Teachers and experts create a ton of content (slides and pdfs mostly) which never reach anybody beyond the participants they teach in the class / conference / meeting room. What a waste! What if we could google and browse course materials, just like we do with regular web pages?

The first obstacle is the limitations that teachers impose on themselves: we refuse that our content should be left in the open. These courses requested big efforts to be created (a PhD! life on the road as a consultant! summers, weekend and nights!) and they crystalize our intellectual value. Making this content available would diminish our originality, it could get copied (stolen!) and taught elsewhere by total strangers. We would become replaceable. Our students or clients would go on the Internet instead of visiting our seminars.

Well, this is not true. Spreading and publicizing your content makes a broader audience interested in what you produce, not less. MOOCs show that (ask https://youtu.be/ESr9z0aKuCc[Andrew Ng]), open source code show that (ask https://wptavern.com/linus-torvalds-explains-how-open-source-led-to-the-success-of-linux[Linus Torvald]), open data shows that as well (ask the http://techpresident.com/blog-entry/open-data-makes-good-advertising-mta[MTA]).

A second obstacle is the use of Microsoft Word, Powerpoint (or Keynote for Mac), and pdf in general: these types of documents are good for the desktop, not for web surfing. So most of the docs stay as files in folders on the hard drives of the teachers's laptops. They might get uploaded to the LMS (the intranet for courses) of the univ / school, but they are not fit for web browsing.

I was stimulated to think  how to do differently by 2 things:

*   a talk by http://hsablonniere.com/[Hubert Sablonnière] at http://webenvert.fr/events/s03e03/[WebEnVert] on AsciiDoc
*   the need to update lots of tutorials I have on http://gephi.org/[Gephi]

What if our course materials and tutorials were as easy to find, edit, maintain and read as webpages?
To achieve that, many free options are available:

[qanda]
Writing courses and tutorials as blog posts in WordPress?::
Not a bad idea actually. WordPress is a "content management system", which sounds about right if we project to manage course content online. It would cover most of the needs: easy for the prof to write and edit, public by default, an admin panel to grant editing access and collect reading stats. A not so minor issue is that whatever written in WordPress doesn't travel easily: a blog post is hard to translate into a slide presentation, a pdf, or an archive to store on one's computer.

Writing slides on https://slides.com/features[Slides.com] or https://www.google.com/slides/about/[Google Slides]?::
These 2 services provide Powerpoint / Keynote functionalities, but in a web browser rather than in a desktop software. It makes it easy to edit, publish and share online presentations. One issue: Slides.com is very limited in its free version (250Mb storage, no export facility). To note: Google Slides is compatible with the Powerpoint pptx format, which is excellent.

AsciiDoc!::
Basically, what you do is write your text in a very simple format: just a plain text document (.txt). Then, you format the text with some very simple signs: these little stars for * *bold text* *, underscores for _ _italic text_  _, and similar stuff to create titles, bullet points, etc. The document you are reading now is written in AsciiDoc. The advantages are:

- with http://asciidocfx.com/[AsciiDocFX] and other free software, you create and turn these txt files into beautiful pdfs, slides, web pages, ebooks!

- asciidoc is really just plain text, so you can use git versioning on it. That's really geek territory here, but very useful: Git is a system that allows you to track and record successive versions of a given document, for an author or even a team of auhors / editors. It works only with text, not files like .pptx or .docx. So, creating documents in asciidoc adds versioning + multiauthoring capabilities to your workflow! Personnally, I find it can be useful to allow students, colleagues and anonymous readers of my courses to suggest edits to the course through this system.

- and given that it is plain text, you have full control on it. Again, geek stuff here, but let's just say that plain text can be handled easily with APIs, contrary to files in .docx or .pptx formats.


To recap:


.Different options to create web-based, open courses and tutorials
[width="90%",cols="8,10,10",options="header"]
|=========================================================
|Solution |Advantages |Inconvenients

|Wordpress |Creates webpages in an easy way. Widely adopted content management system with a mature admin interface and a flexible, familiar text editor.|Poor interface with other systems: what's created on WP stays on WP. Difficult or impossible to turn blog posts into slides, pdfs and ebooks or stand alone webpages. Can handle media imports but not the design of figures.

|Google Docs + Google Drawings + Google Slides |Full solution to create texts, drawings, slides and more, in a "online native" fashion and with familiar tools. Lots of sharing capabilities through embed links and compatible with the MS Office file formats.  | Not easy / impossible to exend with advanced features like git versioning.

|AsciiDoc |Full flexibility in terms of formats, from slides to pdf and ebooks. Made to work with developer tools and web technologies: git, apis, html.  | Does not handle figures, just text. There is a learning curve. Tools are not stable and might break / disappear.

|=========================================================



I choose AsciiDoc, using also Google Drawings for the design of diagrams which I'll embed in my AsciiDocs. For example the following figure was created in in Google Drawings and added to this document through a simple "share link":



In 2017, I am going to experiment with the transition of working on my courses and tutorials from using MS Word + Powerpoint to writing in AsciiDoc format.

The point is to make these documents easy to publish on the web, easier on my side to maintain, and open to the public. I don't have the exact address where you should find these things as I create them, but check http://www.github.com/seinecle[my github account] or http://www.clementlevallois.net[my personal website].

Comments? Questions on this document? Please open https://github.com/seinecle/blog/issues[an issue on Github].
