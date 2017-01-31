=  Twitter Streaming Importer
Clément Levallois <clementlevallois@gmail.com>
2017-01-31

last modified: {docdate}

:icons: font
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]



== Author and documentation

This plugin is created by https://matthieu-totet.fr[Matthieu Totet], who is a long time community member of Gephi (check his https://github.com/totetmatt/GephiStreamer[Gephi Streamer]!)

You can find additional documentation on this plugin on https://matthieu-totet.fr/Koumin/2016/04/25/twitter-streaming-importer-naoyun-as-a-gephi-plugin/[Matthieu's website].

== Description of the plugin

This plugin enables you to:

*   Collect tweets in realtime, on the topic you choose
*   Get the connections between the users mentionned in these tweets
*   Visualize these connections in Gephi, or just export all the tweets to Excel


== Installing the plugin

== !
[WARNING]
The setup of the plugin will need you to create a Twitter account, if you don't already have one.
Get your Twitter login and password ready. **You also need a mobile phone number where your Twitter account can be confirmed**.

== !
[CAUTION]
====
Setting up a Twitter account and creating a Twitter app is a boring task.

It takes just 15 minutes, and you have to do it just once. Then you'll have Twitter at your fingertips.

Let's go!
====

== !

image::Choose-the-menu-Tools-then-Plugins.png[align="center", title="Choose the menu Tools then Plugins"]


== !

image::Click-on-the-tab-Available-Plugins.png[align="center", title="Click on the tab Available Plugins"]

== !

image::Install-the-plugin-then-restart-Gephi.png[align="center", title="Install the plugin then restart Gephi"]


== Initializing the plugin (to be done just once)

== Creating a Twitter account

== !

image::Open-a-new-project-in-Gephi.png[align="center", title="Open a new project in Gephi"]

== !

image::Display-the-plugin-in-Gephi.png[align="center", title="Display the plugin in Gephi"]

== !
We need now to connect to a Twitter account. If you already have a Twitter account and you are logged in, <<twitter-account-finished-setup, skip to here>>.

== !

image::Creating-a-Twitter-account.png[align="center", title="Creating a Twitter account"]

== !

image::Confirmation-of-the-sign-up.png[align="center", title="Confirmation of the sign-up"]

== !

[WARNING]
You have received an email by Twitter about the sign up. At some point (but now would be a good time), you must click on the link in this email to confirm it.


== !

image::Enter-the-verification-code-you-received-by-sms.png[align="center", title="Enter the verification code you received by sms"]


== !

image::Choose-a-username.png[align="center", title="Choose a username"]

== !

The next screens of the sign up for Twitter are not important for us.
Just follow the steps until you get to the page showing your Twitter profile, meaning the setup is finished.



== !

[[twitter-account-finished-setup]]
You now have a Twitter account.
We need to create a Twitter app which will authorize us to collect tweets automatically via Gephi

Go to *https://apps.twiter.com[https://apps.twiter.com]*:

== !

image::Create-a-new-app.png[align="center", title="Create a new app"]

== !

image::Fill-in-the-fields.png[align="center", title="Fill in the fields"]

== !

INFO: Almost there!!

== !

image::Click-on-Keys-and-Access-Tokens.png[align="center", title="Click on Keys and Access Tokens"]

== !

image::Click-on-Create-my-access-token.png[align="center", title="Click on Create my access token"]

== !

image::Copy-paste-these-codes-into-Gephi.png[align="center", title="Copy paste these codes into Gephi"]

== !

image::Where-to-copy-paste-the-codes-in-Gephi.png[align="center", title="Where to copy paste the codes in Gephi"]

== Done!

icon:thumbs-up[] Well done. This setup had just to be done once.
Now we can start using the plugin.


== Using the plugin

== !

image::Adding-terms-and-launching-the-collection-of-tweets.png[align="center", title="Adding terms and launching the collection of tweets"]

== !

Be careful that if you choose very common terms, tweets will arrive fast and in large volumes.
If you don't have enough memory (RAM) on your computer, this could make it crash.
Click on "disconnect" to stop the collection of tweets.


== !
image::en/twitter-streaming-importer/result-plugin-1-en.png[align="center",title="Users mentioned in or retweeting tweets citing the search terms"]


== Applying a layout while the tweets arrive.

You can see the users organize spatially in real time, while the tweets are being collected.

Just run Force Atlas 2 in the "Layout" panel. This will not interrupt the collection of tweets.

== !

image::Running-the-Force-Atlas-layout-while-the-tweets-are-arriving.png[align="center", title="Running the Force Atlas layout while the tweets are arriving"]

== !
Shift to the `data laboratory` to view the data collected, in a spreadsheet format:

image::Switching-to-the-data-laboratory-view.png[align="center", title="Switching to the data laboratory view"]

== !
There, you can export nodes and relations ("edges") as csv files by clicking on "Export table".


== The end!

This plugin has many more features.

Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
