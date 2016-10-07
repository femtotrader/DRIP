
package org.drip.execution.athl;

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
 * CalibrationEmpirics contains the Universal Market Impact Exponent/Coefficients that have been determined
 *  empirically by Almgren, Thum, Hauptmann, and Li (2005), using the Parameterization of Almgren (2003). The
 *  References are:
 * 
 * 	- Almgren, R., and N. Chriss (1999): Value under Liquidation, Risk 12 (12).
 * 
 * 	- Almgren, R., and N. Chriss (2000): Optimal Execution of Portfolio Transactions, Journal of Risk 3 (2)
 * 		5-39.
 * 
 * 	- Almgren, R. (2003): Optimal Execution with Nonlinear Impact Functions and Trading-Enhanced Risk,
 * 		Applied Mathematical Finance 10 (1) 1-18.
 *
 * 	- Almgren, R., and N. Chriss (2003): Bidding Principles, Risk 97-102.
 * 
 * 	- Almgren, R., C. Thum, E. Hauptmann, and H. Li (2005): Equity Market Impact, Risk 18 (7) 57-62.
 * 
 * @author Lakshmi Krishnamurthy
 */

public class CalibrationEmpirics {

	/**
	 * Almgren, Thum, Hauptmann, and Li (2005) Universal Permanent Impact Exponent
	 */

	public static final double PERMANENT_IMPACT_EXPONENT_ATHL2005 = 0.891;

	/**
	 * Almgren, Thum, Hauptmann, and Li (2005) Universal Permanent Impact Exponent One Sigma
	 */

	public static final double PERMANENT_IMPACT_EXPONENT_ATHL2005_ONE_SIGMA = 0.10;

	/**
	 * Quasi-Arbitrage Free Universal Permanent Impact Exponent
	 */

	public static final double PERMANENT_IMPACT_EXPONENT_QUASI_ARBITRAGE_FREE = 1.00;

	/**
	 * Universal Permanent Impact Exponent
	 */

	public static final double PERMANENT_IMPACT_EXPONENT = PERMANENT_IMPACT_EXPONENT_QUASI_ARBITRAGE_FREE;

	/**
	 * Universal Permanent Impact Coefficient
	 */

	public static final double PERMANENT_IMPACT_COEFFICIENT = 0.314;

	/**
	 * Universal Permanent Impact Coefficient One Sigma
	 */

	public static final double PERMANENT_IMPACT_COEFFICIENT_ONE_SIGMA = 0.041;

	/**
	 * The ATHL2005 Permanent Impact Inverse Turnover Coefficient
	 */

	public static final double PERMANENT_IMPACT_INVERSE_TURNOVER_EXPONENT_ATHL2005 = 0.267;

	/**
	 * The ATHL2005 Permanent Impact Inverse Turnover Coefficient One Sigma Error
	 */

	public static final double PERMANENT_IMPACT_INVERSE_TURNOVER_EXPONENT_ATHL2005_ONE_SIGMA = 0.22;

	/**
	 * The Universal Permanent Impact Inverse Turnover Coefficient
	 */

	public static final double PERMANENT_IMPACT_INVERSE_TURNOVER_EXPONENT = 0.25;

	/**
	 * Universal Temporary Impact Exponent
	 */

	public static final double TEMPORARY_IMPACT_EXPONENT = 0.600;

	/**
	 * Universal Temporary Impact Exponent One Sigma
	 */

	public static final double TEMPORARY_IMPACT_EXPONENT_ONE_SIGMA = 0.038;

	/**
	 * Universal Temporary Impact Coefficient
	 */

	public static final double TEMPORARY_IMPACT_COEFFICIENT = 0.142;

	/**
	 * Universal Temporary Impact Coefficient One Sigma
	 */

	public static final double TEMPORARY_IMPACT_COEFFICIENT_ONE_SIGMA = 0.0062;
}