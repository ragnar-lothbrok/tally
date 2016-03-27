#!/usr/bin/perl
my $filename = '/home/raghunandangupta/mygit/tally/demo.txt';
open(my $fh, '<:encoding(UTF-8)', $filename)
  or die "Could not open file '$filename' $!";
 print "<Name>,<Score>\n";
 my $sum = 0.0;
 my $rows = 0;
while (my $row = <$fh>) {
  chomp $row;
  my @words = split /\|/, $row;
  $sum +=$words[3];
  $rows += 1;
print "$words[1],$words[3]\n";
}
print "Average Score : ";
 print int($float + $sum/$rows);
 print "\n";