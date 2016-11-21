
package org.drip.execution.bayesian;

/*
 * -*- mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 */

/*!
 * Copyright (C) 2016 Lakshmi Krishnamurthy
 * 
 *  This file is part of DRIP, a free-software/open-source library for fixed income analysts and developers -
 * 		http://www.credit-trader.org/Begin.html
 * 
 *  DRIP is a free, full featured, fixed income rates, credit, and FX analytics library with a focus towards
 *  	pricing/valuation, risk, and market making.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *   	you may not use this file except in compliance with the License.
 *   
 *  You may obtain a copy of the License at
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  	distributed under the License is distributed on an "AS IS" BASIS,
 *  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  
 *  See the License for the specific language governing permissions and
 *  	limitations under the License.
 */

/**
 * PriorDriftDistribution holds the Prior Belief Distribution associated with the Directional Drift. The
 *  References are:
 * 
 * 	- Bertsimas, D., and A. W. Lo (1998): Optimal Control of Execution Costs, Journal of Financial Markets 1
 * 		1-50.
 * 
 * 	- Almgren, R., and N. Chriss (2000): Optimal Execution of Portfolio Transactions, Journal of Risk 3 (2)
 * 		5-39.
 * 
 * 	- Brunnermeier, L. K., and L. H. Pedersen (2005): Predatory Trading, Journal of Finance 60 (4) 1825-1863.
 *
 * 	- Almgren, R., and J. Lorenz (2006): Bayesian Adaptive Trading with a Daily Cycle, Journal of Trading 1
 * 		(4) 38-46.
 * 
 * 	- Kissell, R., and R. Malamut (2007): Algorithmic Decision Making Framework, Journal of Trading 1 (1)
 * 		12-21.
 * 
 * @author Lakshmi Krishnamurthy
 */

public class PriorDriftDistribution extends org.drip.measure.gaussian.R1UnivariateNormal {

	/**
	 * Construct an Instance of Prior Drift Distribution
	 * 
	 * @param dblExpectation Expectation of the Prior Drift
	 * @param dblConfidence Confidence of the Prior Drift
	 * 
	 * @throws java.lang.Exception Thrown if the Inputs are Invalid
	 */

	public PriorDriftDistribution (
		final double dblExpectation,
		final double dblConfidence)
		throws java.lang.Exception
	{
		super (dblExpectation, dblConfidence);
	}

	/**
	 * Retrieve the Expectation of the Prior Drift Distribution
	 * 
	 * @return The Expectation of the Prior Drift Distribution
	 */

	public double expectation()
	{
		return mean();
	}

	/**
	 * Retrieve the Confidence of the Prior Drift Distribution
	 * 
	 * @return The Confidence of the Prior Drift Distribution
	 */

	public double confidence()
	{
		return java.lang.Math.sqrt (variance());
	}
}