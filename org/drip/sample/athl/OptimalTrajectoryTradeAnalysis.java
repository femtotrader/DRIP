
package org.drip.sample.athl;

import org.drip.execution.athl.DynamicsParameters;
import org.drip.execution.dynamics.Almgren2003Parameters;
import org.drip.execution.generator.Almgren2003TrajectoryScheme;
import org.drip.execution.optimum.Almgren2003TradingTrajectory;
import org.drip.execution.parameters.AssetFlowParameters;
import org.drip.quant.common.FormatUtil;
import org.drip.service.env.EnvManager;

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
 * OptimalTrajectoryTradeAnalysis analyzes the Impact of Input Parameters on the Trade Scheduling using the
 *  Equity Market Impact Functions determined empirically by Almgren, Thum, Hauptmann, and Li (2005), using
 *  the Parameterization of Almgren (2003) for IBM. The References are:
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

public class OptimalTrajectoryTradeAnalysis {

	private static final void TradeSizeSensitivity (
		final double dblADVRatio,
		final double dblTradeSize,
		final Almgren2003Parameters a2003p)
		throws Exception
	{
		double dblTradeTime = 0.5;
		int iNumInterval = 10;

		double dblRiskAversion = 1.e-02;

		Almgren2003TrajectoryScheme a2003ts = Almgren2003TrajectoryScheme.Standard (
			dblTradeSize,
			dblTradeTime,
			iNumInterval,
			a2003p,
			dblRiskAversion
		);

		Almgren2003TradingTrajectory a2003tt = (Almgren2003TradingTrajectory) a2003ts.generate();

		double[] adblHoldings = a2003tt.holdings();

		String strDump = "";

		for (int i = 0; i < adblHoldings.length; ++i)
			strDump = strDump + FormatUtil.FormatDouble (adblHoldings[i] / dblTradeSize, 2, 2, 100.) + "% | ";

		System.out.println (
			"\t| " +
			FormatUtil.FormatDouble (dblADVRatio, 2, 0, 100.) + "% | " + strDump +
			FormatUtil.FormatDouble (a2003tt.characteristicTime(), 1, 3, 1.) + " ||"
		);
	}

	public static final void main (
		final String[] astrArgs)
		throws Exception
	{
		EnvManager.InitEnv ("");

		String strAssetName = "IBM";
		double dblAverageDailyVolume = 6561000.;
		double dblSharesOutstanding = 1728000000.;
		double dblBaseDailyVolatility = 1.57;

		double[] adblADVRatio = new double[] {
			0.01,
			0.02,
			0.03,
			0.04,
			0.06,
			0.08,
			0.10,
			0.15,
			0.20,
			0.25,
			0.30
		};

		Almgren2003Parameters a2003p = new DynamicsParameters (
			new AssetFlowParameters (
				strAssetName,
				dblAverageDailyVolume,
				dblSharesOutstanding,
				dblBaseDailyVolatility
			)
		).almgren2003();

		System.out.println();

		System.out.println ("\t|------------------------------------------------------------------------------------------------------------------------------||");

		System.out.println ("\t|                                        Trade Size Dependence on the Execution Schedule                                       ||");

		System.out.println ("\t|------------------------------------------------------------------------------------------------------------------------------||");

		System.out.println ("\t|                                                L -> R :                                                                      ||");

		System.out.println ("\t|                                                        Trade Size as a Fraction of ADV                                       ||");

		System.out.println ("\t|                                                        Execution Time Nodes                                                  ||");

		System.out.println ("\t|                                                        Characteristic Time                                                   ||");

		System.out.println ("\t|------------------------------------------------------------------------------------------------------------------------------||");

		for (double dblADVRatio : adblADVRatio)
			TradeSizeSensitivity (
				dblADVRatio,
				dblADVRatio * dblAverageDailyVolume,
				a2003p
			);

		System.out.println ("\t|------------------------------------------------------------------------------------------------------------------------------||");
	}
}