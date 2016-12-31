
package org.drip.optimization.kkt.necessary;

/*
 * -*- mode: java; tab-width: 4; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 */

/*!
 * Copyright (C) 2017 Lakshmi Krishnamurthy
 * Copyright (C) 2016 Lakshmi Krishnamurthy
 * 
 *  This file is part of DRIP, a free-software/open-source library for buy/side financial/trading model
 *  	libraries targeting analysts and developers
 *  	https://lakshmidrip.github.io/DRIP/
 *  
 *  DRIP is composed of four main libraries:
 *  
 *  - DRIP Fixed Income - https://lakshmidrip.github.io/DRIP-Fixed-Income/
 *  - DRIP Asset Allocation - https://lakshmidrip.github.io/DRIP-Asset-Allocation/
 *  - DRIP Numerical Optimizer - https://lakshmidrip.github.io/DRIP-Numerical-Optimizer/
 *  - DRIP Statistical Learning - https://lakshmidrip.github.io/DRIP-Statistical-Learning/
 * 
 *  - DRIP Fixed Income: Library for Instrument/Trading Conventions, Treasury Futures/Options,
 *  	Funding/Forward/Overnight Curves, Multi-Curve Construction/Valuation, Collateral Valuation and XVA
 *  	Metric Generation, Calibration and Hedge Attributions, Statistical Curve Construction, Bond RV
 *  	Metrics, Stochastic Evolution and Option Pricing, Interest Rate Dynamics and Option Pricing, LMM
 *  	Extensions/Calibrations/Greeks, Algorithmic Differentiation, and Asset Backed Models and Analytics.
 * 
 *  - DRIP Asset Allocation: Library for model libraries for MPT framework, Black Litterman Strategy
 *  	Incorporator, Holdings Constraint, and Transaction Costs.
 * 
 *  - DRIP Numerical Optimizer: Library for Numerical Optimization and Spline Functionality.
 * 
 *  - DRIP Statistical Learning: Library for Statistical Evaluation and Machine Learning.
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
 * ConditionQualifier holds the Condition Name, the Condition Order, and the Condition Validity Flag that
 *  correspond to the Necessary and the Sufficient Conditions. The References are:
 * 
 * 	- Boyd, S., and L. van den Berghe (2009): Convex Optimization, Cambridge University Press, Cambridge UK.
 * 
 * 	- Eustaquio, R., E. Karas, and A. Ribeiro (2008): Constraint Qualification for Nonlinear Programming,
 * 		Technical Report, Federal University of Parana.
 * 
 * 	- Karush, A. (1939): Minima of Functions of Several Variables with Inequalities as Side Constraints,
 * 		M. Sc., University of Chicago, Chicago IL.
 * 
 * 	- Kuhn, H. W., and A. W. Tucker (1951): Nonlinear Programming, Proceedings of the Second Berkeley
 * 		Symposium, University of California, Berkeley CA 481-492.
 * 
 * 	- Ruszczynski, A. (2006): Nonlinear Optimization, Princeton University Press, Princeton NJ.
 * 
 * @author Lakshmi Krishnamurthy
 */

public class ConditionQualifier {
	private int _iOrder = -1;
	private boolean _bValid = false;
	private java.lang.String _strDescription = "";

	/**
	 * ConditionQualifier Constructor
	 * 
	 * @param strDescription Condition Qualifier Description
	 * @param iOrder Order of the Condition - Typically First/Second
	 * @param bValid Condition Qualifier Validity
	 * 
	 * @throws java.lang.Exception Thrown if the Inputs are Invalid
	 */

	public ConditionQualifier (
		final java.lang.String strDescription,
		final int iOrder,
		final boolean bValid)
		throws java.lang.Exception
	{
		if (null == (_strDescription = strDescription) || _strDescription.isEmpty() || 0 > (_iOrder =
			iOrder))
			throw new java.lang.Exception ("ConditionQualifier Constructor => Invalid Inputs");

		_bValid = bValid;
	}

	/**
	 * Retrieve the Condition Qualifier Description
	 * 
	 * @return The Condition Qualifier Description
	 */

	public java.lang.String description()
	{
		return _strDescription;
	}

	/**
	 * Retrieve the Condition Qualifier Order
	 * 
	 * @return The Condition Qualifier Order
	 */

	public int order()
	{
		return _iOrder;
	}

	/**
	 * Retrieve the Condition Qualifier Validity
	 * 
	 * @return The Condition Qualifier Validity
	 */

	public boolean valid()
	{
		return _bValid;
	}

	/**
	 * Convert the Condition Qualifier into a Display String
	 * 
	 * @return The Condition Qualifier into a Display String
	 */

	public java.lang.String display()
	{
		return "[ " + _strDescription + " | " + _iOrder + " ORDER => " + _bValid + "]";
	}
}
