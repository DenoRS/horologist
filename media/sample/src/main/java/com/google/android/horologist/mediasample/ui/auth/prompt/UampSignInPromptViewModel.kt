/*
 * Copyright 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.horologist.mediasample.ui.auth.prompt

import androidx.lifecycle.viewModelScope
import com.google.android.horologist.auth.data.common.repository.AuthUserRepository
import com.google.android.horologist.auth.ui.common.screens.prompt.SignInPromptViewModel
import com.google.android.horologist.mediasample.domain.SettingsRepository
import com.google.android.horologist.mediasample.domain.proto.copy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UampSignInPromptViewModel @Inject constructor(
    authUserRepository: AuthUserRepository,
    private val settingsRepository: SettingsRepository
) :
    SignInPromptViewModel(authUserRepository) {
    fun selectGuestMode() {
        viewModelScope.launch {
            settingsRepository.edit {
                it.copy {
                    guestMode = true
                }
            }
        }
    }
}
