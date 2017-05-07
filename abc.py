listGrades = ['A', 'B', 'C', 'D', 'F', 'A', 'B', 'C', 'D', 'F', 'A', 'B', 'C', 'D', 'F'];
listCredits = [3, 1 , 2 , 3, 2, 3, 1 , 2 , 3, 2, 3, 1 , 2 , 3, 2];

dictionary = {'A':4, 'B':3, 'C':2, 'D':1, 'F':0};
total = 0;
maximumCredits = 0;
print ("(grade,credit)");
for i, j in zip(listGrades, listCredits):
    print(i, j);
    weight = dictionary[i];
    total += j * weight;
    maximumCredits += j * dictionary['A'];

print ("Student Total Credits : ") ;
print(total);
print ("Maximum Credits : ");
print (maximumCredits);
print ("Student GPA : ");
print ((float(total) / float(maximumCredits)) * dictionary['A']);
