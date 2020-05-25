#!/usr/bin/env python
# coding: utf-8

# In[2]:


import numpy as np
import seaborn as sns
import pandas as pd
import pyswarms as ps


# In[3]:


get_ipython().run_line_magic('load_ext', 'autoreload')
get_ipython().run_line_magic('autoreload', '2')
get_ipython().run_line_magic('matplotlib', 'inline')


# In[4]:


from sklearn.datasets import make_classification
from sklearn.datasets import load_wine

data= pd.read_csv("train.csv")
#print(data.head)

y=data.iloc[:200,-1].to_numpy()
X = data.iloc[:200,:-1].to_numpy()



# X, y = make_classification(n_samples=100, n_features=15, n_classes=3,
#                            n_informative=4, n_redundant=1, n_repeated=2,
#                            random_state=1)
# print(type(y))

# Plot dataset per feature

# df = pd.DataFrame(X)
# df['labels'] = pd.Series(y)

# sns.pairplot(data, hue='price_range');


# In[5]:


from sklearn import linear_model

# Create an instance of the classifier
classifier = linear_model.LogisticRegression(solver='liblinear',multi_class='ovr')

# Define objective function
def f_per_particle(m, alpha):
    """Computes for the objective function per particle

    Inputs
    ------
    m : numpy.ndarray
        Binary mask that can be obtained from BinaryPSO, will
        be used to mask features.
    alpha: float (default is 0.5)
        Constant weight for trading-off classifier performance
        and number of features

    Returns
    -------
    numpy.ndarray
        Computed objective function
    """
    total_features = 20
    # Get the subset of the features from the binary mask
    if np.count_nonzero(m) == 0:
        X_subset = X
    else:
        X_subset = X[:,m==1]
    # Perform classification and store performance in P
    classifier.fit(X_subset, y)
    P = (classifier.predict(X_subset) == y).mean()
    # Compute for the objective function
    j = (alpha * (1.0 - P)
        + (1.0 - alpha) * (1 - (X_subset.shape[1] / total_features)))

    return j


# In[6]:


def f(x, alpha=0.88):
    """Higher-level method to do classification in the
    whole swarm.

    Inputs
    ------
    x: numpy.ndarray of shape (n_particles, dimensions)
        The swarm that will perform the search

    Returns
    -------
    numpy.ndarray of shape (n_particles, )
        The computed loss for each particle
    """
    n_particles = x.shape[0]
    
    print(type(x), x[5])
    j = [f_per_particle(x[i], alpha) for i in range(n_particles)]
    return np.array(j)


# In[7]:


# Initialize swarm, arbitrary

options = {'c1': 0.5, 'c2': 0.5, 'w':0.9, 'k': 30, 'p':2}

# Call instance of PSO
dimensions = 20 # dimensions should be the number of features
# optimizer = ps.discrete.BinaryPSO(n_particles=30, dimensions=dimensions, options=options)
# optimizer.reset()
optimizer = ps.discrete.BinaryPSO(n_particles=30, dimensions=dimensions, options=options)

# Perform optimization
cost, pos = optimizer.optimize(f, iters=1000)


# In[8]:


# Create two instances of LogisticRegression
classifier = linear_model.LogisticRegression()
classifier_main = linear_model.LogisticRegression()

# Get the selected features from the final positions
X_selected_features = X[:,pos==1]  # subset
print(X_selected_features, X)
# Perform classification and store performance in P
classifier.fit(X_selected_features, y)
classifier_main.fit(X, y)

# Compute performance
subset_performance = (classifier.predict(X_selected_features) == y).mean()
main_perf = (classifier_main.predict(X) == y).mean()

print('Subset performance: %.3f' % (subset_performance))
print('Main performance: %.3f' % (main_perf))


# In[9]:


# Plot toy dataset per feature
# df1 = pd.DataFrame(X_selected_features)
# df1['labels'] = pd.Series(y)

# sns.pairplot(df1, hue='labels')


# In[ ]:




