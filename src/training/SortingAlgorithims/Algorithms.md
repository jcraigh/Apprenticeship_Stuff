# Introductions in to Algorithms
## Question
>You are running a peer-to-peer lending website that attempts to match borrowers (people who want a loan) to lenders (people who want to invest their money by lending it to someone else). You have found that as your business grows your current matching algorithm is getting too slow, so you want to find a better one. You've done some research and have identified a number of options:

>Option A has time complexity O(n+m) and memory complexity O(n^m) (n to the power of m)

>Option B has time complexity O(n*log(m)) and memory complexity O(n *m)

>Option C has time complexity O(n*m) and memory complexity O(n+m)

#### Which option do you think is most appropriate, and why? What other factors might you need to consider in making your decision?

There are a few things that need to be considered when picking a algorithm like how big is the matching search.

Option B will be better if there is a bigger matching search as the speed will if put on a graph will be a logarithmic curve so the curve will slow down and the bigger the search will effect the speed less and less

Option A will be better if there is a smaller matching search as this is a constant search increase so if it was put on a graph it would start with less time then option B but option B will become quicker once the search is big enough

So the best option that I could use is using option A and option B but use A for small searches and B for large searches.