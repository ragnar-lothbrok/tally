<?php

function CompanyRecruitment($input1,$input2)
	{
		if(sizeof($input1) == 0 || sizeof($input1) < $input2 || $input2 == 0){
			return "0";
		}	

		rsort($input1);

		$selectCount = 0 ;$totalCount = 0;



		for($var =0;$var <sizeof($input1);$var++){
			if($input1[$input2-1] == $input1[$var]){

				if($var <= ($input2 -1)){
					$selectCount++;
				}
				$totalCount++;
			}
			
		}

		$fact1 = getFactorial($totalCount,$selectCount);
		$fact2 = getFactorial($selectCount,$selectCount);
	
		return  ($fact1/$fact2);

	}

	function getFactorial($num,$count)
	{
	    $fact = $num;
	    for($i = 1; $i < $count ;$i++){
	    	$fact = $fact * ($num -1 );
	    	$num = $num -1;
	    }
	    return $fact;
	}
echo CompanyRecruitment(array(2,5,1,2,4,1,2,5,5,5),1);
?>
