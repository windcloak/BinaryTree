# BinaryTree
Reads a txt file of movies and outputs it in a binary tree

This program develops a custom class of movies. It will read a comma-separated text file of movies with the title, year, rating, and review. Then it will output the information in a binary tree in another text file. The user can specify if the order is preorder, postorder, or inorder. 

A = add to list
D = delete from list

**Example input**
'''
A,Spiderman,2018,PG,3
A,The Twelve Chairs,1970,G,1
A,Snow Dogs,2002,PG,2
D,The Twelve Chairs,1970
A,Spiderman,2002,PG-13,4
A,Ralph Breaks the Internet,2018,PG,3
A,Frozen,2014,PG,3
'''
**Inorder**

Title:   Frozen     
Year:    2014       
Rating:  PG         
Review:  3          

Title:   Ralph Breaks the Internet 
Year:    2018       
Rating:  PG         
Review:  3          

Title:   Snow Dogs  
Year:    2002       
Rating:  PG         
Review:  2          

Title:   Spiderman  
Year:    2018       
Rating:  PG         
Review:  3          

**Preorder**

Title:   Spiderman  
Year:    2018       
Rating:  PG         
Review:  3          

Title:   Snow Dogs  
Year:    2002       
Rating:  PG         
Review:  2          

Title:   Ralph Breaks the Internet 
Year:    2018       
Rating:  PG         
Review:  3          

Title:   Frozen     
Year:    2014       
Rating:  PG         
Review:  3          

**Postorder**

Title:   Spiderman  
Year:    2018       
Rating:  PG         
Review:  3          

Title:   Snow Dogs  
Year:    2002       
Rating:  PG         
Review:  2          

Title:   Ralph Breaks the Internet 
Year:    2018       
Rating:  PG         
Review:  3          

Title:   Frozen     
Year:    2014       
Rating:  PG         
Review:  3          
