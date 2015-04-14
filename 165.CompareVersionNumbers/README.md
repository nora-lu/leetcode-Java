You need to escape the dot if you want to split on a literal dot:

String extensionRemoved = filename.split("\\.")[0];
Otherwise you are splitting on the regex ., which means "any character".
Note the double backslash needed to create a single backslash in the regex.
