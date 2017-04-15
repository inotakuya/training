chdir "C:/Users/i_no_/Documents/git/training";
my $command = "git log --oneline --grep aa";
open my $rs, "$command 2>&1 |";
my @result = <$rs>;
close $rs;
print join '', @result;