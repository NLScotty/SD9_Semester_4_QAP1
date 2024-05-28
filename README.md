This is my Submission for QAP 1

For coming up with use cases I did a breif read of the algorithm used and noticed that it should be able to generate suggestions not only from typos, but from additional and missing characters.
I decided to have my test cases reflect this by making tests that have missing or additonal characters, as well as having tests with both missing/additional characters and a spelling mistake.
An observation I made is that it had a hard time with the tests with missing characters (atleast in the exmple of hello). This is due to the large amount of small 4/5 letter words. 
Using the tests as a guidline to where I want the search engine to be, I removed alot of names and less popular words until hello was present in the top results of all test cases.
I think if I were to flesh out this algorithm more, I would have some common words have additional weight to them (such as hello) over less used words (such as bilo).

In addition to the project, I have set up the branch rules as the QAP instructed, and have a test branch on the repo to test the functionality of the main branch rule.
