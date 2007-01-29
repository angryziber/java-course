<h1>Thank you, $name$!</h1>

<div class="note">
Your contact data and answers have been saved.
</div>

<h2>Totals</h2>
<div class="note">
	Correct answers: $correctAnswers$<br/>
	Wrong answers: $wrongAnswers$<br/>
	Percentage: $percentage$%<br/>
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
