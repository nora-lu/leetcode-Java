The idea is as follows:

first, if person A knows person B, then B could be the candidate of being a celebrity, A must not be a celebrity. We iterate all the n persons and we will have a candidate that everyone knows this candidate.

second, we check two things after we get this candidate. 1. If this candidate knows other person in the group, if the candidate knows anyone in the group, then the candidate is not celebrity, return -1; 2. if everyone knows this candidate, if anyone does not know the candidate, return -1;

the first run checks only if everyone AFTER the candidate knows him / her and need one more run to check if everyone BEFORE the candidate knows him.
