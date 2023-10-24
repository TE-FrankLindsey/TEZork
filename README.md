# TEZork
Zork inspired text adventure game written as side project in TechElevator boot camp

For optional 'side project' while attending Tech Elevator boot camp I decided to code a text based console adventure game with a, seeming, natural language parser.
Basic operation of the parser is to break command text into verb and noun which can then be acted on.  Basic steps of the parser are as follows-
1) command text is copied into the parser object which resets the 'parser pointer' to zero.  All parse operations are made against the command string from the location of the parse pointer.
2) The varb is searched for.  Verbs are stored indivicually as objects.  One object for each type of verb supported, such as 'get', 'drop' and 'open'.
  Verb search is performed by sequencing through each verb object 'asking' it if it matches the command text (at the parser pointer).  A matching verb is stored as the currVerb'
  Verbs match against the name of the verb examined and any synonyms for that verb.  Such as, 'take' matches against text of 'take', 'get' or 'pick up'.
3) When a verb is found the parser scans command text from the current position to remove blanks and connecting words such as 'a', 'an' or 'the'.
4) Then the search is made for the noun.  Like verbs, nouns are saved as objects of hhe nouns recognized, when a noun matches in the command the noun is saved as currNoun and the parser pointer advances.
   When searching for the noun it accepts an optional 'modifier' which preceeds the noun.  When found the parser pointer will advance past the modifer text in the command.
5) Next a prepositional phrase is searched for in the form of a leading word, such as 'with', 'from' or 'onto'.  Finding a leading word and noun the noun is saved as the prepNoun.
6) Once the currVerb, currNoun and (optional) prepNoun are found the Verb base class is called on its method of 'doAction' which executes the overloaded method in the child class.
7) In doAction the noun is tested if the action can be applied to the currNoun.
  Each noun stores in the 'int attributes' field its attributes as bit values.  Each attribute is stored as a single bit value (1,2,4,8...) with all attributes ORed together
8) If the action can be applied to the noun then the verb checks if the noun should override its operation
9) If the currVerb action can be applied to the currNoun then the test is made if there is access to the currNoun, access is available when the noun object is in the room or player's possession.
10) If the currVerb and currNoun are found and available and can be made then the action of the currVerb is made with the currNoun
