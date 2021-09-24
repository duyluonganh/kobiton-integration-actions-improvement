# kobiton-integration-actions-improvement


### How to improve Katalon Mobile keywords: tap, setText, etc... on Kobiton

1. Create package `com.kms.katalon.core.mobile.keyword.internal` under Keywords folder
2. Create `MobileAbstractKeyword` with the this [content](https://github.com/duyluonganh/kobiton-integration-actions-improvement/blob/main/Keywords/com/kms/katalon/core/mobile/keyword/internal/MobileAbstractKeyword.groovy).

<img src="https://raw.githubusercontent.com/duyluonganh/kobiton-integration-actions-improvement/main/Images/1-create-keyword.png" width=70% alt="1-create-keyword">

### Result

Before apply the work-around

<img src="https://raw.githubusercontent.com/duyluonganh/kobiton-integration-actions-improvement/main/Images/2-before-workaround.png" width=70% alt="2-before-workaround">

After apply the work-around

<img src="https://raw.githubusercontent.com/duyluonganh/kobiton-integration-actions-improvement/main/Images/2-after-workaround.png" width=70% alt="2-after-workaround">
