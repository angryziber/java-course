<h1>Thank you and welcome to the course, $name$!</h1>

<div class="note">
Your contact data and answers have been saved.<br/>
You can now access <a href="http://svn.azib.net/java/">Subversion repository</a>.<br/> 
Your username is <b>$username$</b>. Use the password that you have submitted.
</div>

<h2>Totals</h2>
<div class="note">
	Correct answers: $correctAnswers$<br/>
	Wrong answers: $wrongAnswers$<br/>
	Percentage: $percentage$%<br/>
	Time taken: $time$<br/>
</div>

<h2>Answers</h2>
<ol>
	$answers:{a|
		<li><div class="$if(a.correct)$correct$else$wrong$endif$">$a.question.text$</div></li>	
		Your answer: $a.answers; separator=", "$<br/>
		Correct answer: $a.question.correct; separator=", "$<br/>
		<br/>
	}$
</ol>
