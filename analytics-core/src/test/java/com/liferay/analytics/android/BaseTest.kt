/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.analytics.android

import android.content.pm.PackageManager
import android.os.Bundle
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.test.KoinTest
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * @author Allan Melo
 */
@Config(constants = BuildConfig::class, sdk = [26])
@RunWith(RobolectricTestRunner::class)
abstract class BaseTest: KoinTest {
    @Before
    fun init() {
        startKoin(Analytics.getModules(RuntimeEnvironment.application))
    }

    @After
    fun after() {
        closeKoin()
    }

    fun getApplicationMetaData(): Bundle {
        val context = RuntimeEnvironment.application
        val applicationInfo =
            context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)

        return applicationInfo.metaData
    }
}