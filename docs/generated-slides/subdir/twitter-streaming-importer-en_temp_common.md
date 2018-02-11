=  Twitter Streaming Importer
Clément Levallois <clementlevallois@gmail.com>;Matthieu Totet <matthieu.totet@gmail.com>
2017-01-31

last modified: {docdate}

:icons: font
:iconsfont:   font-awesome
:revnumber: 1.0
:example-caption!:
:sourcedir: ../../../../main/java

:title-logo-image: gephi-logo-2010-transparent.png[width="450" align="center"]

image::gephi-logo-2010-transparent.png[width="450" align="center"]
{nbsp} +

//ST: 'Escape' or 'o' to see all sides, F11 for full screen, 's' for speaker notes


== 1. Description of the plugin
//ST: Description of the plugin

//ST: !
This plugin is created by https://matthieu-totet.fr[Matthieu Totet], who is a long time community member of Gephi (check his https://github.com/totetmatt/GephiStreamer[Gephi Streamer]!)

You can find additional documentation on this plugin on https://matthieu-totet.fr/Koumin/2016/04/25/twitter-streaming-importer-naoyun-as-a-gephi-plugin/[Matthieu's website].


//ST: !
This plugin enables you to:

*   Collect tweets in realtime, on the topic you choose
*   Get the connections between the users mentionned in these tweets
*   Visualize these connections in Gephi, or just export all the tweets to Excel

== 2. Installing the plugin
//ST: 2. Installing the plugin

//ST: !
[WARNING]
====
The setup of the plugin will need you to create a Twitter account, if you don't already have one.
Get your Twitter login and password ready. **You also need a mobile phone number where your Twitter account can be confirmed**.
====

//ST: !
[CAUTION]
====
Setting up a Twitter account and creating a Twitter app is a boring task.
It takes just 15 minutes, and you have to do it just once. Then you'll have Twitter at your fingertips.

Let's go!
====

//ST: !

image::Choose-the-menu-Tools-then-Plugins.png[align="center", title="Choose the menu Tools then Plugins"]
{nbsp} +


//ST: !
image::Click-on-the-tab-Available-Plugins.png[align="center", title="Click on the tab Available Plugins"]
{nbsp} +

//ST: !
image::Install-the-plugin-then-restart-Gephi.png[align="center", title="Install the plugin then restart Gephi"]
{nbsp} +

== 3. Initializing the plugin (to be done just once)
//ST: 3. Initializing the plugin (to be done just once)

//ST: !
==== a. Creating a Twitter account
//ST: Creating a Twitter account

//ST: !
image::Open-a-new-project-in-Gephi.png[align="center", title="Open a new project in Gephi"]
{nbsp} +

//ST: !
image::Display-the-plugin-in-Gephi.png[align="center", title="Display the plugin in Gephi"]
{nbsp} +

//ST: !
We need now to connect to a Twitter account. If you already have a Twitter account and you are logged in, <<twitter-account-finished-setup, skip to here>>.

//ST: !
image::Creating-a-Twitter-account.png[align="center", title="Creating a Twitter account"]
{nbsp} +

//ST: !
image::Confirmation-of-the-sign-up.png[align="center", title="Confirmation of the sign-up"]
{nbsp} +

//ST: !
[WARNING]
====
You have received an email by Twitter about the sign up.
At some point (but now would be a good time), you must click on the link in this email to confirm it.
====

//ST: !
image::Enter-the-verification-code-you-received-by-sms.png[align="center", title="Enter the verification code you received by sms"]
{nbsp} +


//ST: !
image::Choose-a-username.png[align="center", title="Choose a username"]
{nbsp} +

//ST: !
The next screens of the sign up for Twitter are not important for us.
Just follow the steps until you get to the page showing your Twitter profile, meaning the setup is finished.

//ST: !
[[twitter-account-finished-setup]]
You now have a Twitter account.
We need to create a Twitter app which will authorize us to collect tweets automatically via Gephi

//ST: !
==== b. Creating a Twitter app
//ST: Creating a Twitter app

Go to *https://apps.twiter.com[https://apps.twiter.com]*:

//ST: !
image::Create-a-new-app.png[align="center", title="Create a new app"]
{nbsp} +

//ST: !
image::Fill-in-the-fields.png[align="center", title="Fill in the fields"]
{nbsp} +

//ST: !
INFO: Almost there!!

//ST: !
image::Click-on-Keys-and-Access-Tokens.png[align="center", title="Click on Keys and Access Tokens"]
{nbsp} +

//ST: !
image::Click-on-Create-my-access-token.png[align="center", title="Click on Create my access token"]
{nbsp} +

//ST: !
image::Copy-paste-these-codes-into-Gephi.png[align="center", title="Copy paste these codes into Gephi"]
{nbsp} +

//ST: !
image::Where-to-copy-paste-the-codes-in-Gephi.png[align="center", title="Where to copy paste the codes in Gephi"]
{nbsp} +

//ST: !
Done!

icon:thumbs-up[] Well done. This setup had just to be done once.
Your credentials are saved and will be loaded at each run.
Now we can start using the plugin.

== 3. Using the plugin
//ST: Using the plugin

//ST: !
With the ** Words to follow ** tab, you will be able to follow one or multiple words. For ** hashtags **, just enter the word without the hash in front of it. (e.g if you want to follow '**#Gephi**' just add '**Gephi**')

//ST: !
With the ** Users to follow ** tab, you will be able to follow the activity of one or multiple users. Any tweet from this user or retweeting or mentioning the user will be captured. You can also import all users from a
twitter list by giviing the `user name` of the twitter account and the `list name` to import.

//ST: !
image::en/twitter-streaming-importer/twitter-user-list.png[align="center", title="How to add user from a Twitter List"]
{nbsp} +

//ST: !
With the ** Locations to follow ** tab, you will be able to follow the activity of one or multiple locations. Any tweet that has been geotagged will be captured. You need to delimit the zone to track by its South West Point and the Nord East Point.

//ST: !
image::en/twitter-streaming-importer/geo_params.png[align="center", title="How to add a Locations"]
{nbsp} +

//ST: !
You can combine the 2 tabs, the tweet collected will be matching either the Words to follow query **or** the User to follow query

//ST: !
The ** Load Query File** and ** Save Query File ** buttons are here to save your search queries in a file or to load it from a file. It's convenient if you have
a long list of words / users.

//ST: !
==== a. Network Logic

//ST: !
A ** Network Logic ** means: what should be done with an incoming tweet? How to transform it as a set of nodes and edges?

//ST: The dropdown menu to choose the network logic:

image::Selection-of-the-network-logic.png[align="center",title="Selection of the network logic"]
{nbsp} +

//ST: !
There are for the moment 3 Network Logics to choose from:

//ST: !
* Full Twitter Network : This will represent **all** entities (User, Tweet, Hastags, URL, Media, Symbol etc...) as a graph.
* User Network : This will represent the interaction between users. Any mentions, retweets or quotes between 2 users, will be represented. The size of the edge represent the number of interactions between 2 users.
* Hashtag Network : This will create the network of hashtag.

//ST: !
In the following, we use the network logic "User Network":

//ST: !
image::Adding-terms-and-launching-the-collection-of-tweets.png[align="center", title="Adding terms and launching the collection of tweets"]
{nbsp} +

//ST: !

Be careful that if you choose very common terms, tweets will arrive fast and in large volumes.

If you don't have enough memory (RAM) on your computer, this could make it crash.

Click on "disconnect" to stop the collection of tweets.


//ST: !
image::en/twitter-streaming-importer/result-plugin-1-en.png[align="center",title="Users mentioned in or retweeting tweets citing the search terms"]
{nbsp} +


//ST: !
==== b. Applying a layout while the tweets arrive.

//ST: !
You can see the users organize spatially in real time, while the tweets are being collected.

Just run Force Atlas 2 in the "Layout" panel. This will not interrupt the collection of tweets.

//ST: !

image::Running-the-Force-Atlas-layout-while-the-tweets-are-arriving.png[align="center", title="Running the Force Atlas layout while the tweets are arriving"]
{nbsp} +

//ST: !
Shift to the `data laboratory` to view the data collected, in a spreadsheet format:

//ST: !
image::Switching-to-the-data-laboratory-view.png[align="center", title="Switching to the data laboratory view"]
{nbsp} +

//ST: !
There, you can export nodes and relations ("edges") as csv files by clicking on "Export table".

//ST: !
==== c. Timeline

//ST: !

When you are finished with your stream, you can use the ** timeline ** feature to replay the stream of data and look at a particular time window.

_This feature is still experimental and is higly subject to bug._

//ST: !
image::en/twitter-streaming-importer/timeline-enable.png[align="center", title="How to activate the Timeline"]
{nbsp} +

//ST: !
image::en/twitter-streaming-importer/timeline.gif[align="center", title="Example of Timeline"]
{nbsp} +

== The end

//ST: The end!

Visit https://www.facebook.com/groups/gephi/[the Gephi group on Facebook] to get help,

or visit https://seinecle.github.io/gephi-tutorials/[the website for more tutorials]
